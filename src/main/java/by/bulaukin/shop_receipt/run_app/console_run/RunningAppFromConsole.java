package by.bulaukin.shop_receipt.run_app.console_run;

import by.bulaukin.shop_receipt.entity_to_dto.ResultChangingEntityToDto;
import by.bulaukin.shop_receipt.entity_to_dto.ChangingEntityToDtoService;
import by.bulaukin.shop_receipt.pars_data.ParamsTypeEnum;
import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
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

    private final ChangingEntityToDtoService resultEntityToDtoService;
    private final ParsingDataFromRequestsParamFactory parsingDataFromRequestsParamFactory;
    private final ReceiptsViewServices viewServices;
    private final PrintingViews printingToConsole;

    public <T>void run(T args) {
        String[] requestsParam = (String[]) args;

        try {
            ParsingDataFromRequestsParam dataFromConsoleParam = parsingDataFromRequestsParamFactory
                    .getClass(ParamsTypeEnum.CONSOLE);
            RequestsParsingResult parsingResult = dataFromConsoleParam.parsData(requestsParam);
            ResultChangingEntityToDto result = resultEntityToDtoService.getResult(parsingResult);
            viewServices.createsView(result);
            printingToConsole.printViews();
        } catch (Exception e){
            log.error("Request {} is not corrected", requestsParam);
        }

    }
}
