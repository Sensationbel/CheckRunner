package by.bulaukin.shop_receipt.countcost;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "sales")
public class DiscountsProperties {
    private Short SalesDiscount;
    private Short NumberDiscount;
}
