package by.bulaukin.shop_receipt.countcost;

import by.bulaukin.shop_receipt.countcost.dto.CostInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value = "byNumberDiscountServiceIpl")
@Log4j2
@RequiredArgsConstructor
public class ByNumberDiscountServiceIpl implements DiscountService{

    @Value("${sales.number-discount}")
    private Short discount;

    @Override
    public void applyDiscount(CostInfo cost) {
        log.debug("Discount by number is {} ", discount);
        cost.setPrice(cost.getPrice() - (cost.getPrice() * discount) / 100);
    }
}
