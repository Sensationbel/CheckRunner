package by.bulaukin.shop_receipt.run_app.factory;

import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromParamsFiles;
import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromRequestsParam;
import by.bulaukin.shop_receipt.view.print.PrintingToFile;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("runAppFromFile")
@RequiredArgsConstructor
public class RunAppFromFile implements ParsingAndViewFactory{

    private final ParsingDataFromParamsFiles parsingDataFromParamsFiles;
    private final PrintingToFile printingToFile;

    @Override
    public ParsingDataFromRequestsParam createParsingDataFromRequestsParam() {
        return parsingDataFromParamsFiles;
    }

    @Override
    public PrintingViews createPrintingViews() {
        return printingToFile;
    }
}
