package by.bulaukin.shop_receipt.pars_data.getting_data;

import by.bulaukin.shop_receipt.pars_data.ParamsTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component(value = "parsingDataFromRequestsParamFactory")
@RequiredArgsConstructor
public class ParsingDataFromRequestsParamFactory {
    private final ParsingDataFromConsoleParam parsingDataFromConsoleParam;
    private final ParsingDataFromParamsFiles parsingDataFromParamsFiles;
    private final ParsingDataFromParamsUrL parsingDataFromParamsUrL;

    public ParsingDataFromRequestsParam getClass(ParamsTypeEnum type) {

        ParsingDataFromRequestsParam data = null;

        switch (type){
            case CONSOLE -> data = parsingDataFromConsoleParam;
            case FILE -> data = parsingDataFromParamsFiles;
            case URL -> data = parsingDataFromParamsUrL;
            default -> throw new IllegalArgumentException("Wrong doughnut type:" + type);
        }
        return data;
    }
}
