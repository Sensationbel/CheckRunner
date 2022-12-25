package by.bulaukin.shop_receipt.countcost;

import by.bulaukin.shop_receipt.countcost.dto.CostInfo;

public interface DiscountService {

    void applyDiscount(CostInfo cost);
}
