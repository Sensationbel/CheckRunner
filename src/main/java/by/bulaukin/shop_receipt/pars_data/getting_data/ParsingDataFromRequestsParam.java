package by.bulaukin.shop_receipt.pars_data.getting_data;

import java.io.IOException;

public interface ParsingDataFromRequestsParam {

   <T> String[] parsData(T request) throws IOException;

}
