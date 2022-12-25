package by.bulaukin.shop_receipt.pars_data;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DataFromRequestServices{

    @Autowired
    private DataFromRequest.DataBuilder dataFromRequest;

    public DataFromRequest parsData(String[] data) {
        String regexItems = "(\\d+)(-)(\\d+)";
        String regexCard = "(card)(-)(\\d+)";

        for (String s : data) {
            s = s.trim();
            String[] split = s.split("-");

            try {
                if (validate(s, regexItems, regexCard)) {
                    if (s.matches(regexItems)) {
                        dataFromRequest
                                .addItems(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
                    } else if (s.matches(regexCard)) {
                        dataFromRequest
                                .addCardNumber(Integer.valueOf(split[1]));
                    }
                }
            } catch (IllegalArgumentException e) {
                log.error(e.getMessage());
            }
        }
        return dataFromRequest.build();
    }

    private boolean validate(String s, String regexItems, String regexCard) {
        if (s.matches(regexItems) || s.matches(regexCard)) {
            return true;
        } else throw new IllegalArgumentException(s + " is not a valid");
    }
}
