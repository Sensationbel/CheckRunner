package by.bulaukin.shop_receipt.pars_data.getting_data;

import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;

import java.io.IOException;

public interface ParsingDataFromRequestsParam {

   <T> RequestsParsingResult parsData(T request) throws IOException;

}
