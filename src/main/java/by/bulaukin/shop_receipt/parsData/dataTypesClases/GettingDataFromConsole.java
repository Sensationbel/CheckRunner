package by.bulaukin.shop_receipt.parsData.dataTypesClases;

import by.bulaukin.shop_receipt.parsData.DataFromRequest;
import by.bulaukin.shop_receipt.parsData.DataTypes;
import by.bulaukin.shop_receipt.parsData.GettingData;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GettingDataFromConsole implements GettingData {

    private String regexItems = "(\\d+)(=)(\\d+)";
    @Override
    public <T> DataFromRequest parsData(T data) {
        DataFromRequest dataFromRequest = new DataFromRequest();
        String[] array = (String[]) data;
        for (int i = 0; i < array.length; i++) {
            if(array[i].matches(regexItems)){
                System.out.println(array[i]);
            }
        }
        return null;
    }
}
