package by.bulaukin.shop_receipt.pars_data.getting_data;

import by.bulaukin.shop_receipt.pars_data.RequestsParsingResultService;
import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service(value = "parsingDataFromParamsFiles")
@Log4j2
@RequiredArgsConstructor
public class ParsingDataFromParamsFiles implements ParsingDataFromRequestsParam {

    private final RequestsParsingResultService requestsParsingResultService;
    @Override
    public <T> RequestsParsingResult parsData(T request) throws IOException {

        String[] data = (String[]) request;

        byte[] content = Files.readAllBytes(Paths.get(data[0]));
        String[] requestsParam = new String(content).split("\s+");
        return requestsParsingResultService.addDataToRequestsParsingResult(requestsParam);

    }
}
