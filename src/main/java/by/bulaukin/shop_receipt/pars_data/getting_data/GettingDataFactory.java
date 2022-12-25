package by.bulaukin.shop_receipt.pars_data.getting_data;

import by.bulaukin.shop_receipt.pars_data.DataFromRequestServices;
import by.bulaukin.shop_receipt.pars_data.DataTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GettingDataFactory {
    private final DataFromRequestServices console;
    private final GettingDataFromFile file;
    private final GettingDataFromUrL url;

    public GettingData getClass(DataTypes type) {

        GettingData data = null;

        switch (type){
            case FILE -> data = file;
            case URL -> data = url;
            default -> throw new IllegalArgumentException("Wrong doughnut type:" + type);
        }
        return data;
    }
}
