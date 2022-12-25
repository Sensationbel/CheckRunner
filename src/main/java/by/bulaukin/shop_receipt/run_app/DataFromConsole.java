package by.bulaukin.shop_receipt.run_app;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "dataFromConsole")
@Getter
@Setter
public class DataFromConsole {

    private String[] args;
}
