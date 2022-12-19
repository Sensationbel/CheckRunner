package by.bulaukin.shop_receipt.parsData.gettingData;

import by.bulaukin.shop_receipt.parsData.DataFromRequest;

public class GettingDataFromConsole implements GettingData {

    @Override
    public <T> DataFromRequest parsData(T data) {
        DataFromRequest dataFromRequest = new DataFromRequest();
        String[] array = (String[]) data;
        String regexItems = "(\\d+)(-)(\\d+)";

        for (String s : array) {
            String[] split = s.split("-");

            if (s.matches(regexItems)) {
                dataFromRequest = new DataFromRequest.DataBuilder(dataFromRequest)
                        .addItems(Integer.valueOf(split[0]), Integer.valueOf(split[1]))
                        .build();
            } else if (s.startsWith("card")) {
                dataFromRequest = new DataFromRequest.DataBuilder(dataFromRequest)
                        .addCardNumber(Integer.valueOf(split[1]))
                        .build();
            }
        }
        return dataFromRequest;
    }
}
