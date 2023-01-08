package by.bulaukin.shop_receipt.pars_data;

import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import by.bulaukin.shop_receipt.pars_data.data.ItemsFromRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class RequestsParsingResultService {

    public RequestsParsingResult addDataToRequestsParsingResult(String[] data) {
        RequestsParsingResult parsingResult = new RequestsParsingResult();

        String regexItems = "(\\d+)(-)(\\d+)";
        String regexCard = "(card)(-)(\\d+)";

        for (String d : data) {
            d = d.trim();
            String[] split = d.split("-");

            try {
                if (validate(d, regexItems, regexCard)) {
                    if (d.matches(regexItems)) {
                        ItemsFromRequest items = new ItemsFromRequest();
                        items.setItemsId(Integer.valueOf(split[0]));
                        items.setItemsQua(Integer.valueOf(split[1]));
                        parsingResult.getItemsList().add(items);
                    } else if (d.matches(regexCard)) {
                        parsingResult.setCardNumber(Integer.valueOf(split[1]));
                    }
                }
            } catch (IllegalArgumentException e) {
                log.error(e.getMessage());
            }
        }
        return parsingResult;
    }

    private boolean validate(String data, String regexItems, String regexCard) {
        if (data.matches(regexItems) || data.matches(regexCard)) {
            return true;
        } else throw new IllegalArgumentException(data + " is not a valid");
    }
}
