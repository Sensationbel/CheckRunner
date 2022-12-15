package by.bulaukin.shop_receipt.parsData;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataFromRequest {

    private final Map<Integer,Integer> items = new HashMap<>();
    private Integer cardNumber = 0;

    public static class Builder {

        DataFromRequest data;

        public Builder(){
            this.data = new DataFromRequest();
        }

        public Builder addItems(Integer itemsId, Integer itemsCount) {
            this.data.items.put(itemsId, itemsCount);
            return this;
        }

        public Builder addCardNumber(Integer cardNumber) {
            this.data.cardNumber = cardNumber;
            return this;
        }

        public DataFromRequest build() {
            return data;
        }

    }
}
