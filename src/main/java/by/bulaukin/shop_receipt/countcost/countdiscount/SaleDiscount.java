package by.bulaukin.shop_receipt.countcost.countdiscount;

import by.bulaukin.shop_receipt.countcost.CountingCost;
import by.bulaukin.shop_receipt.countcost.DiscountsProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
@Getter
@Setter
@Log4j2
public class SaleDiscount extends CountingDiscount{

    private final CountingCost cost;

    private DiscountsProperties prop;

    @Value("${sales.discount}")
    private Short discount = prop.getSalesDiscount();

    @Override
    public double countCost() {
        log.info("On sale discount {}: ", discount);
        return cost.countCost() - (cost.countCost() * discount / 100);
    }

    @Override
    public void setDiscount(Short discount) {
        this.discount = discount;
    }
}
