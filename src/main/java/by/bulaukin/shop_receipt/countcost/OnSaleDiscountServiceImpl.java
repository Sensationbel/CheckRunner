package by.bulaukin.shop_receipt.countcost;

import by.bulaukin.shop_receipt.countcost.dto.CostInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service(value = "onSaleDiscountServiceImpl")
@Log4j2
@RequiredArgsConstructor
public class OnSaleDiscountServiceImpl implements DiscountService{

    @Value("${sales.sales-discount}")
    private  Short discount;

    @Override
    public void applyDiscount(CostInfo cost) {
        log.debug("On sale discount is {} percent", discount);
        cost.setPrice(cost.getPrice() - (cost.getPrice() * discount) / 100);
    }
}
