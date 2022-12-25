package by.bulaukin.shop_receipt.view.print;

import by.bulaukin.shop_receipt.view.convert.ConvertingViews;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service(value = "printingToConsole")
@RequiredArgsConstructor
public class PrintingToConsole implements PrintingViews{

    private final ConvertingViews receiptsViewToString;

    @Override
    public void printViews() {

        System.out.println((String) receiptsViewToString.convertsViews());
    }
}
