package by.bulaukin.shop_receipt.run_app.factory;

import by.bulaukin.shop_receipt.pars_data.getting_data.ParsingDataFromRequestsParam;
import by.bulaukin.shop_receipt.view.print.PrintingViews;


public interface ParsingAndPrintingViewFactory {

    ParsingDataFromRequestsParam createParsingDataFromRequestsParam();
    PrintingViews createPrintingViews();
}
