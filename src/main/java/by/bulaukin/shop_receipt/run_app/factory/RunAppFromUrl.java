package by.bulaukin.shop_receipt.run_app.factory;

import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromParamsUrL;
import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromRequestsParam;
import by.bulaukin.shop_receipt.view.print.PrintingToUrl;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("runAppFromUrl")
@RequiredArgsConstructor
public class RunAppFromUrl implements ParsingAndViewFactory{
    private final ParsingDataFromParamsUrL parsingDataFromParamsUrL;
    private final PrintingToUrl printingToUrl;

    @Override
    public ParsingDataFromRequestsParam createParsingDataFromRequestsParam() {
        return parsingDataFromParamsUrL;
    }

    @Override
    public PrintingViews createPrintingViews() {
        return printingToUrl;
    }
}
