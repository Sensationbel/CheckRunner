package by.bulaukin.shop_receipt.pars_data.getting_data;

import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import org.springframework.stereotype.Service;

@Service(value = "parsingDataFromParamsUrL")
public class ParsingDataFromParamsUrL implements ParsingDataFromRequestsParam {
    @Override
    public <T> RequestsParsingResult parsData(T request) {
        return null;
    }
}
