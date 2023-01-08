package by.bulaukin.shop_receipt.run_app.factory;

import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromHTMLParams;
import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromRequestsParam;
import by.bulaukin.shop_receipt.view.print.PrintingToHTML;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Primary
@Service("parsingAndPrintingParamsFromHTML")
@RequiredArgsConstructor
public class ParsingAndPrintingParamsFromHTML implements ParsingAndPrintingViewFactory {
    private final ParsingDataFromHTMLParams parsingDataFromHTMLParams;
    private final PrintingToHTML printingToHTML;

    @Override
    public ParsingDataFromRequestsParam createParsingDataFromRequestsParam() {
        return parsingDataFromHTMLParams;
    }

    @Override
    public PrintingViews createPrintingViews() {
        return printingToHTML;
    }
}
