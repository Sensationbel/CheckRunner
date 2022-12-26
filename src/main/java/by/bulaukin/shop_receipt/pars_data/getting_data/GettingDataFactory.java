package by.bulaukin.shop_receipt.pars_data.getting_data;

import by.bulaukin.shop_receipt.pars_data.DataTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GettingDataFactory {
    private final GettingDataFromConsole gettingDataFromConsole;
    private final GettingDataFromFile gettingDataFromFile;
    private final GettingDataFromUrL gettingDataFromUrL;

    public GettingData getClass(DataTypes type) {

        GettingData data = null;

        switch (type){
            case CONSOLE -> data = gettingDataFromConsole;
            case FILE -> data = gettingDataFromFile;
            case URL -> data = gettingDataFromUrL;
            default -> throw new IllegalArgumentException("Wrong doughnut type:" + type);
        }
        return data;
    }
}
