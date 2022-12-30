package by.bulaukin.shop_receipt.pars_data.getting_data;

import org.springframework.stereotype.Service;

@Service(value = "parsingDataFromParamsUrL")
public class ParsingDataFromParamsUrL implements ParsingDataFromRequestsParam {
    @Override
    public <T> String[] parsData(T request) {
        return null;
    }
}
