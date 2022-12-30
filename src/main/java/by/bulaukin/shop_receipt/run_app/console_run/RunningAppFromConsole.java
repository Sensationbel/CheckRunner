package by.bulaukin.shop_receipt.run_app.console_run;

import by.bulaukin.shop_receipt.entity_to_dto.ResultEntityToDto;
import by.bulaukin.shop_receipt.entity_to_dto.ResultEntityToDtoService;
import by.bulaukin.shop_receipt.pars_data.ParamsTypeEnum;
import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import by.bulaukin.shop_receipt.pars_data.RequestsParsingResultService;
import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromRequestsParam;
import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromRequestsParamFactory;
import by.bulaukin.shop_receipt.run_app.RunningApp;
import by.bulaukin.shop_receipt.view.ReceiptsViewServices;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service(value = "runningAppFromConsole")
@RequiredArgsConstructor
@Log4j2
public class RunningAppFromConsole implements RunningApp {

    private final RequestsParsingResultService requestsParsingResultService;
    private final ResultEntityToDtoService resultEntityToDtoService;
    private final ParsingDataFromRequestsParamFactory parsingDataFromRequestsParamFactory;
    private final ReceiptsViewServices viewServices;
    private final PrintingViews printingToConsole;

    public <T>void run(T args) {
        String[] requestsParam = (String[]) args;
        RequestsParsingResult parsResult = new RequestsParsingResult();
        try {
            ParsingDataFromRequestsParam dataFromConsoleParam = parsingDataFromRequestsParamFactory.getClass(ParamsTypeEnum.CONSOLE);
            String[] data = dataFromConsoleParam.parsData(requestsParam);
            requestsParsingResultService.addDataToRequestsParsingResult(data, parsResult);
            ResultEntityToDto result = resultEntityToDtoService.getResult(parsResult);
            viewServices.createsView(result);
            printingToConsole.printViews();
        } catch (Exception e){
            log.error("Request {} is not corrected", requestsParam);
        }

    }
}
