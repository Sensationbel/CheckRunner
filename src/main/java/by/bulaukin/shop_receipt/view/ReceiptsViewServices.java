package by.bulaukin.shop_receipt.view;

import by.bulaukin.shop_receipt.countcost.ByNumberDiscountServiceIpl;
import by.bulaukin.shop_receipt.countcost.DiscountService;
import by.bulaukin.shop_receipt.countcost.dto.CostInfo;
import by.bulaukin.shop_receipt.dto_service.dto.ProductsDto;
import by.bulaukin.shop_receipt.entity_to_dto.ResultEntityToDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReceiptsViewServices {

    private final DiscountService cardDiscountServiceImpl;
    private final DiscountService onSaleDiscountServiceImpl;
    private final ByNumberDiscountServiceIpl byNumberDiscountServiceIpl;
    private final ReceiptsView.ViewsBuilder builder;

    public void createsView(ResultEntityToDto result) {

        double totalPrice = getTotalPrice(result.getProductsDtoList());
        double taxable = getTaxable(result);
        int discount = getDiscount(totalPrice, taxable);

        builder
                .addReceiptsBody(result.getProductsDtoList())
                .addTotalPrice(totalPrice)
                .addTaxable(taxable)
                .addDiscount(discount)
                .addDiscountAmount(totalPrice - taxable)
                .build();
    }

    private int getDiscount(double totalPrice, double taxable) {
        return (int) Math.round(100 - (taxable * 100) / totalPrice);
    }

    private double getTaxable(ResultEntityToDto result) {
        return result.getProductsDtoList().stream().map(prod -> {
            CostInfo cost = new CostInfo();
            cost.setPrice(prod.getPrice());
            if(prod.isOnSale()) {
                onSaleDiscountServiceImpl.applyDiscount(cost);
            }
            if(prod.getQuantity() > 5){
                byNumberDiscountServiceIpl.applyDiscount(cost);
            }
            if (result.getCardDiscount() > 0) {
                cost.setDiscount(result.getCardDiscount());
                cardDiscountServiceImpl.applyDiscount(cost);
            }
            return cost.getPrice() * prod.getQuantity();
        }).reduce(Double::sum)
                .orElse(0.0);
    }

    private double getTotalPrice(List<ProductsDto> productsDtoList) {
        return productsDtoList.stream().map(ProductsDto::getItemsTotalPrice).reduce(Double::sum).orElse(0.0);
    }
}
