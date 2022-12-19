package by.bulaukin.shop_receipt.countcost;

public class CountingItemsCost extends CountingCost{

    @Override
    public double countCost() {
        return getPrice() * getCount();
    }
}
