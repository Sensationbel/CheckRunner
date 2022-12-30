package by.bulaukin.shop_receipt.run_app.console_run;

import by.bulaukin.shop_receipt.entity_to_dto.ResultEntityToDto;
import by.bulaukin.shop_receipt.entity_to_dto.ResultEntityToDtoService;
import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import by.bulaukin.shop_receipt.pars_data.RequestsParsingResultService;
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

    private final RequestsParsingResultService dataFromRequestServices;
    private final ResultEntityToDtoService resultEntityToDtoService;
    private final ReceiptsViewServices viewServices;
    private final ParsingDataFromRequestsParamFactory gettingDataFactory;
    private final PrintingViews printingToFile;

    public<T> void run(T args) {
        String[] requestsParam = (String[]) args;
        RequestsParsingResult dataFromRequest = new RequestsParsingResult();
        try {
            ParsingDataFromRequestsParam dataFromFiles = gettingDataFactory.getClass(ParamsTypeEnum.FILE);
            String[] data = dataFromFiles.parsData(requestsParam);
            dataFromRequestServices.addDataToRequestsParsingResult(data, dataFromRequest);
            ResultEntityToDto result = resultEntityToDtoService.getResult(dataFromRequest);
            viewServices.createsView(result);
            printingToFile.printViews();
        } catch (Exception e) {
            log.error("Path {} does not exist",requestsParam[0]);
        }

    }
}
