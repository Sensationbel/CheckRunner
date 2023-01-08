package by.bulaukin.shop_receipt.countcost;

import by.bulaukin.shop_receipt.countcost.info.CostInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value = "cardDiscountServiceImpl")
@RequiredArgsConstructor
@Log4j2
public class CardDiscountServiceImpl implements DiscountService {

    @Value("${sales.card-discount}")
    private Short discount;

    @Override
    public void applyDiscount(CostInfo cost) {

        log.debug("Discount by cards is {} percent", cost.getDiscount());
        cost.setPrice(cost.getPrice() - (cost.getPrice() * cost.getDiscount() / 100));
    }
}
