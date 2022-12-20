package by.bulaukin.shop_receipt.countcost.countdiscount;

import by.bulaukin.shop_receipt.countcost.CountingCost;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public class CardDiscount extends CountingDiscount {

    private final CountingCost cost;
    private Short discount;

    @Override
    public double countCost() {
        log.info("Discount by cards {}: ", discount);
        return cost.countCost() - (cost.countCost() * discount / 100);
    }

    @Override
    public void setDiscount(Short discount) {
        this.discount = discount;
    }
}
