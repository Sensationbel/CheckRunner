package by.bulaukin.shop_receipt.run_app;

import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import by.bulaukin.shop_receipt.run_app.factory.ParsingAndPrintingParamsFromHTML;
import by.bulaukin.shop_receipt.run_app.factory.ParsingAndPrintingViewFactory;
import by.bulaukin.shop_receipt.run_app.factory.ParsingAndPrintingConsoleParam;
import by.bulaukin.shop_receipt.run_app.factory.ParsingAndPrintingParamsFromFile;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class RequestParsingResultFromRequestsParam {

    private ParsingAndPrintingViewFactory parsingAndPrintingViewFactory;
    private final ParsingAndPrintingConsoleParam parsingAndPrintingConsoleParam;
    private final ParsingAndPrintingParamsFromFile parsingAndPrintingParamsFromFile;
    private final ParsingAndPrintingParamsFromHTML parsingAndPrintingParamsFromHTML;
    @Autowired
    private PrintingViews printingViews;

    public PrintingViews getPrintingViews() {
        return printingViews;
    }


    public<T> RequestsParsingResult getRequestParsingResult(T requestParams) throws IOException {
        TypeParams typeParams = null;

        if(requestParams == null){
            return new RequestsParsingResult();
        }

        if(requestParams instanceof String[]){
            String[] arrayParams = (String[]) requestParams;

            if(arrayParams.length == 1){
                typeParams = TypeParams.CONSOLE_FILE;
            } else {
                typeParams = TypeParams.CONSOLE_ARRAY_ITEMS;
            }
        } else if(requestParams instanceof RequestsParsingResult){
            typeParams = TypeParams.HTML;
        }

        createParsingAndViewFactory(typeParams);
        printingViews = parsingAndPrintingViewFactory.createPrintingViews();
        return parsingAndPrintingViewFactory.createParsingDataFromRequestsParam().parsData(requestParams);
    }

    private void createParsingAndViewFactory(TypeParams typeParams) {
        switch (typeParams){
            case CONSOLE_FILE -> parsingAndPrintingViewFactory = parsingAndPrintingParamsFromFile;
            case HTML -> parsingAndPrintingViewFactory = parsingAndPrintingParamsFromHTML;
            case CONSOLE_ARRAY_ITEMS -> parsingAndPrintingViewFactory = parsingAndPrintingConsoleParam;
            default -> throw new IllegalArgumentException("Type params " + typeParams +" is not corrected. " +
                    "ParsingAndPrintingViewFactory was not created.");
        }
    }

    private enum TypeParams{
        CONSOLE_ARRAY_ITEMS,
        CONSOLE_FILE,
        HTML
    }
}
