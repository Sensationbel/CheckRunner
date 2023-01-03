package by.bulaukin.shop_receipt.run_app.run;

import by.bulaukin.shop_receipt.entity_to_dto.ResultChangingEntityToDto;
import by.bulaukin.shop_receipt.entity_to_dto.ChangingEntityToDtoService;
import by.bulaukin.shop_receipt.run_app.factory.ParsingAndViewFactory;
import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import by.bulaukin.shop_receipt.view.ReceiptsViewServices;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunningAppFromUrl implements RunningApp {

    private final ChangingEntityToDtoService resultEntityToDtoService;
    private final ReceiptsViewServices viewServices;
    private ParsingAndViewFactory parsingAndViewFactory;

    @Override
    public<T> void run( T requestsParam) {
        PrintingViews printingToUrl = parsingAndViewFactory.createPrintingViews();
        ResultChangingEntityToDto result = resultEntityToDtoService.getResult((RequestsParsingResult) requestsParam);
        viewServices.createsView(result);
        printingToUrl.printViews();


    }

    @Override
    public void setParsingAndViewFactory(ParsingAndViewFactory factory) {
        this.parsingAndViewFactory = factory;
    }
}
