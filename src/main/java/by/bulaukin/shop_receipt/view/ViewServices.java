package by.bulaukin.shop_receipt.view;

import by.bulaukin.shop_receipt.countcost.CountingCost;
import by.bulaukin.shop_receipt.countcost.CountingItemsCost;
import by.bulaukin.shop_receipt.countcost.countdiscount.CardDiscount;
import by.bulaukin.shop_receipt.countcost.countdiscount.DiscountByNumber;
import by.bulaukin.shop_receipt.countcost.countdiscount.SaleDiscount;
import by.bulaukin.shop_receipt.dtoService.dto.ProductsDto;
import by.bulaukin.shop_receipt.entityToDto.ResultEntityToDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ViewServices {

    private final ResultEntityToDto result;

    public View createsView(){

        double totalPrice = getTotalPrice(result.getProductsDtoList());
        double taxable = getTaxable(result);
        int discount = getDiscount(totalPrice, taxable);

        View view = new View.ViewsBuilder()
                .addReceiptsBody(result.getProductsDtoList())
                .addTotalPrice(totalPrice)
                .addTaxable(taxable)
                .addDiscount(discount)
                .build();
        return view;
    }

    private int getDiscount(double totalPrice, double taxable) {
        return (int) Math.round(100 - (taxable * 100)/totalPrice);
    }

    private double getTaxable(ResultEntityToDto result) {
        return result.getProductsDtoList().stream().map(prod -> {
            CountingCost cost = new CountingItemsCost();
            cost.setPrice(prod.getPrice());
            cost.setCount(prod.getCount());
            if(prod.isOnSale()) {
                cost = new SaleDiscount(cost);
            }
            if(prod.getCount() > 5){
                cost = new DiscountByNumber(cost);
            }
            if(result.getCardDiscount() > 0){
                cost = new CardDiscount(cost);
                cost.setDiscount(result.getCardDiscount());
            }
            return cost.countCost();
        }).reduce((a, b) -> a + b).orElse(0.0);
    }

    private double getTotalPrice(List<ProductsDto> productsDtoList) {
        return productsDtoList.stream().map(ProductsDto::getItemsTotalPrice).reduce((a, b) -> a + b).orElse(0.0);
    }
}
