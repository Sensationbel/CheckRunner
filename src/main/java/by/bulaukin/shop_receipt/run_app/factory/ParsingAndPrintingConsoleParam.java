package by.bulaukin.shop_receipt.run_app.factory;

import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromConsoleParam;
import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromRequestsParam;
import by.bulaukin.shop_receipt.view.print.PrintingToConsole;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("parsingAndPrintingConsoleParam")
@RequiredArgsConstructor
public class ParsingAndPrintingConsoleParam implements ParsingAndPrintingViewFactory {

    private final ParsingDataFromConsoleParam parsingDataFromConsoleParam;
    private final PrintingToConsole printingToConsole;

    @Override
    public ParsingDataFromRequestsParam createParsingDataFromRequestsParam() {
        return parsingDataFromConsoleParam;
    }

    @Override
    public PrintingViews createPrintingViews() {
        return printingToConsole;
    }
}
