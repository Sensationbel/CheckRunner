package by.bulaukin.shop_receipt.parsData;

import by.bulaukin.shop_receipt.parsData.dataTypesClases.GettingDataFromConsole;
import by.bulaukin.shop_receipt.parsData.dataTypesClases.GettingDataFromFile;
import by.bulaukin.shop_receipt.parsData.dataTypesClases.GettingDataFromUrL;
import org.springframework.stereotype.Component;

@Component
public class GettingDataFactory {

    public GettingData getClass(DataTypes type) {

        GettingData data = null;
        switch (type){
            case CONSOLE -> data = new GettingDataFromConsole();
            case FILE -> data = new GettingDataFromFile();
            case URL -> data = new GettingDataFromUrL();
            default -> throw new IllegalArgumentException("Wrong doughnut type:" + type);
        }
        return data;
    }
}
