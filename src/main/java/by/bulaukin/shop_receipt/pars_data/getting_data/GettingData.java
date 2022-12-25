package by.bulaukin.shop_receipt.pars_data.getting_data;

import java.io.IOException;

public interface GettingData {

   <T> String[] parsData(T request) throws IOException;

}
