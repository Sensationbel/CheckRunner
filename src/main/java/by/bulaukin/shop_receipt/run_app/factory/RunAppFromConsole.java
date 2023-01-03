package by.bulaukin.shop_receipt.run_app.factory;

import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromConsoleParam;
import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromRequestsParam;
import by.bulaukin.shop_receipt.view.print.PrintingToConsole;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("runAppFromConsole")
@RequiredArgsConstructor
public class RunAppFromConsole implements ParsingAndViewFactory{

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
