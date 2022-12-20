package by.bulaukin.shop_receipt.countcost;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public abstract class CountingCost {

    private double price;
    private int count;
    private Short discount;
    public abstract double countCost();
}
