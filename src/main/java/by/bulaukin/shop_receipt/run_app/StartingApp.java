package by.bulaukin.shop_receipt.run_app;

import by.bulaukin.shop_receipt.ShopReceiptApplication;
import by.bulaukin.shop_receipt.entity_to_dto.ResultChangingEntityToDto;
import by.bulaukin.shop_receipt.entity_to_dto.ChangingEntityToDtoService;
import by.bulaukin.shop_receipt.run_app.RequestParsingResultFromRequestsParam;
import by.bulaukin.shop_receipt.run_app.factory.ParsingAndPrintingViewFactory;
import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import by.bulaukin.shop_receipt.view.ReceiptsViewServices;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Log4j2
public class StartingApp {

    private final RequestParsingResultFromRequestsParam requestParsingResultFromRequestsParam;
    private final ChangingEntityToDtoService resultEntityToDtoService;
    private final ReceiptsViewServices viewServices;

    public <T> void startApp(T requestsParam) throws IOException {
        RequestsParsingResult requestParsingResult = requestParsingResultFromRequestsParam
                .getRequestParsingResult(requestsParam);
        ResultChangingEntityToDto result = resultEntityToDtoService.getResult(requestParsingResult);
        viewServices.createsView(result);
        requestParsingResultFromRequestsParam.getPrintingViews().printViews();
    }
}
