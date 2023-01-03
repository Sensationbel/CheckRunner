package by.bulaukin.shop_receipt.run_app.factory;

import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromRequestsParam;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import org.springframework.stereotype.Component;

@Component
public interface ParsingAndViewFactory {

    ParsingDataFromRequestsParam createParsingDataFromRequestsParam();
    PrintingViews createPrintingViews();
}
