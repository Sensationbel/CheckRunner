package by.bulaukin.shop_receipt.pars_data.getting_data;

import by.bulaukin.shop_receipt.pars_data.RequestsParsingResultService;
import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service(value = "parsingDataFromConsoleParam")
@RequiredArgsConstructor
public class ParsingDataFromConsoleParam implements ParsingDataFromRequestsParam {

    private final RequestsParsingResultService requestsParsingResultService;
    @Override
    public <T> RequestsParsingResult parsData(T request) throws IOException {
        return requestsParsingResultService.addDataToRequestsParsingResult((String[]) request);
    }
}
