package by.bulaukin.shop_receipt.run_app.url_run;

import by.bulaukin.shop_receipt.entity_to_dto.ResultChangingEntityToDto;
import by.bulaukin.shop_receipt.entity_to_dto.ChangingEntityToDtoService;
import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import by.bulaukin.shop_receipt.run_app.RunningApp;
import by.bulaukin.shop_receipt.view.ReceiptsViewServices;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunningAppFromUrl implements RunningApp {

    private final ChangingEntityToDtoService resultEntityToDtoService;
    private final ReceiptsViewServices viewServices;
    private final PrintingViews printingToUrl;

    @Override
    public<T> void run( T requestsParam) {

        ResultChangingEntityToDto result = resultEntityToDtoService.getResult((RequestsParsingResult) requestsParam);
        viewServices.createsView(result);
        printingToUrl.printViews();


    }
}
