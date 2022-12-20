package by.bulaukin.shop_receipt.countcost.countdiscount;

import by.bulaukin.shop_receipt.countcost.CountingCost;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
@Getter
@Setter
@Log4j2
public class DiscountByNumber extends CountingDiscount{
    private final CountingCost cost;

    @Value("${number.discount}")
    private Short discount;

    @Override
    public double countCost() {
        log.info("Discount By Number {}: ", discount);
        return cost.countCost() - (cost.countCost() * discount / 100);
    }

    @Override
    public void setDiscount(Short discount) {
        this.discount = discount;
    }
}
