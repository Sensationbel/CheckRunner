package by.bulaukin.shop_receipt.run_app.console_run;

import by.bulaukin.shop_receipt.entity_to_dto.ResultChangingEntityToDto;
import by.bulaukin.shop_receipt.entity_to_dto.ChangingEntityToDtoService;
import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import by.bulaukin.shop_receipt.pars_data.ParamsTypeEnum;
import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromRequestsParam;
import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromRequestsParamFactory;
import by.bulaukin.shop_receipt.run_app.RunningApp;
import by.bulaukin.shop_receipt.view.ReceiptsViewServices;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class RunningAppFromFile implements RunningApp {
    private final ChangingEntityToDtoService entityToDtoService;
    private final ReceiptsViewServices viewServices;
    private final ParsingDataFromRequestsParamFactory parsingDataFromRequestsParamFactory;
    private final PrintingViews printingToFile;

    public<T> void run(T args) {
        String[] requestsParam = (String[]) args;

        try {
            ParsingDataFromRequestsParam dataFromFiles = parsingDataFromRequestsParamFactory.getClass(ParamsTypeEnum.FILE);
            RequestsParsingResult parsingResult = dataFromFiles.parsData(requestsParam);
            ResultChangingEntityToDto result = entityToDtoService.getResult(parsingResult);
            viewServices.createsView(result);
            printingToFile.printViews();
        } catch (Exception e) {
            log.error("Path {} does not exist",requestsParam[0]);
        }

    }
}
