package by.bulaukin.shop_receipt.countcost.countdiscount;

import by.bulaukin.shop_receipt.countcost.CountingCost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class CardDiscount extends CountingDiscount {

    private final CountingCost cost;
    private int discount;

    @Override
    public double countCost() {
        return cost.countCost() - (cost.countCost() * discount / 100);
    }

    @Override
    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
