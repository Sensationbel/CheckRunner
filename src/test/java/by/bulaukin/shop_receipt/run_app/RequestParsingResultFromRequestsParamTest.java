package by.bulaukin.shop_receipt.run_app;

import by.bulaukin.shop_receipt.pars_data.data.ItemsFromRequest;
import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class RequestParsingResultFromRequestsParamTest {

    @Autowired
    private RequestParsingResultFromRequestsParam requestParsingResultFromRequestsParam;

    private String[] paramFromConsole;
    private String[] paramFromFile;
    private String[] errorParams;
    private RequestsParsingResult result;
    private RequestsParsingResult testResult;

    @BeforeEach
    void setUp() {
        paramFromConsole = new String[]{"11-6", "13-6", "5-1", "1-3", "20-2", "card-2569 "};
        paramFromFile = new String[]{"C:\\Users\\Sensationbel\\Desktop\\data.txt"};
        errorParams = new String[]{"11=6"};
        result = new RequestsParsingResult();
        result.getItemsList().addAll(Arrays.asList(
                new ItemsFromRequest(11, 6),
                new ItemsFromRequest(13, 6),
                new ItemsFromRequest(5, 1),
                new ItemsFromRequest(1, 3),
                new ItemsFromRequest(20, 2)
        ));
        result.setCardNumber(2569);
    }

    @AfterEach
    void tearDown() {
        result = null;
        paramFromConsole = null;
        paramFromFile = null;
        requestParsingResultFromRequestsParam = null;
    }

    @Test
    void getRequestParsingResult_should_get_testResult_from_paramFromConsole() throws IOException {
        testResult = requestParsingResultFromRequestsParam.getRequestParsingResult(paramFromConsole);
        assertThat(testResult).isNotNull();
        assertThat(testResult.getCardNumber()).isEqualTo(result.getCardNumber());
        assertThat(testResult.getItemsList()).hasSameElementsAs(result.getItemsList());
    }

    @Test
    void getRequestParsingResult_should_get_testResult_from_paramFromFile() throws IOException {
        testResult = requestParsingResultFromRequestsParam.getRequestParsingResult(paramFromFile);
        assertThat(testResult.getCardNumber()).isEqualTo(result.getCardNumber());
        assertThat(testResult.getItemsList()).hasSameElementsAs(result.getItemsList());
    }

    @Test
    void getRequestParsingResult_should_get_testResult_from_HTMLParam() throws IOException {
        testResult = requestParsingResultFromRequestsParam.getRequestParsingResult(result);
        assertThat(testResult.getCardNumber()).isEqualTo(result.getCardNumber());
        assertThat(testResult.getItemsList()).hasSameElementsAs(result.getItemsList());
    }

    @Test
    void getRequestParsingResult_should_get_new_object() throws IOException {
        testResult = requestParsingResultFromRequestsParam.getRequestParsingResult(null);
        assertThat(testResult).isInstanceOf(RequestsParsingResult.class);
    }

    @Test()
    void getRequestParsingResult_should_get_error_by_errorParams() throws IOException {
        try {
            testResult = requestParsingResultFromRequestsParam.getRequestParsingResult(errorParams);
        }catch (Exception e){
            e.getMessage();
        }    }
}