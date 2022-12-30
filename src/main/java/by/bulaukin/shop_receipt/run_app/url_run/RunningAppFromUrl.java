package by.bulaukin.shop_receipt.run_app.url_run;

import by.bulaukin.shop_receipt.entity_to_dto.ResultEntityToDto;
import by.bulaukin.shop_receipt.entity_to_dto.ResultEntityToDtoService;
import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import by.bulaukin.shop_receipt.run_app.RunningApp;
import by.bulaukin.shop_receipt.view.ReceiptsViewServices;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunningAppFromUrl implements RunningApp {

    private final ResultEntityToDtoService resultEntityToDtoService;
    private final ReceiptsViewServices viewServices;
    private final PrintingViews printingToUrl;

    @Override
    public<T> void run( T params) {

        ResultEntityToDto result = resultEntityToDtoService.getResult((RequestsParsingResult)params);
        viewServices.createsView(result);
        printingToUrl.printViews();


    }
}
