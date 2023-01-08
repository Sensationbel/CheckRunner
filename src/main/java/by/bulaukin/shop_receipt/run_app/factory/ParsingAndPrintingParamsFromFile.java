package by.bulaukin.shop_receipt.run_app.factory;

import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromParamsFiles;
import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromRequestsParam;
import by.bulaukin.shop_receipt.view.print.PrintingToFile;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Primary
@Service("parsingAndPrintingParamsFromFile")
@RequiredArgsConstructor
public class ParsingAndPrintingParamsFromFile implements ParsingAndPrintingViewFactory {

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
