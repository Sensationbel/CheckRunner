package by.bulaukin.shop_receipt.pars_data.getting_data;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service(value = "parsingDataFromConsoleParam")
public class ParsingDataFromConsoleParam implements ParsingDataFromRequestsParam {
    @Override
    public <T> String[] parsData(T request) throws IOException {
        return (String[]) request;
    }
}
