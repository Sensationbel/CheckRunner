package by.bulaukin.shop_receipt.pars_data.getting_data;

import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import org.springframework.stereotype.Service;

@Service(value = "parsingDataFromParamsUrL")
public class ParsingDataFromHTMLParams implements ParsingDataFromRequestsParam {
    @Override
    public <T> RequestsParsingResult parsData(T requestParams) {
        return (RequestsParsingResult) requestParams;
    }
}
