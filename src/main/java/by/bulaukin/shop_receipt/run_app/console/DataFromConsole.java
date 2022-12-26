package by.bulaukin.shop_receipt.run_app.console;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component(value = "dataFromConsole")
@Getter
@Setter
public class DataFromConsole {

    private String[] args;
}
