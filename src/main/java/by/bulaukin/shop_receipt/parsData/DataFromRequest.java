package by.bulaukin.shop_receipt.parsData;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ToString
public class DataFromRequest {

    private final Map<Integer,Integer> items = new HashMap<>();
    private Integer cardNumber;

    public static class Builder {

        DataFromRequest data;

        public Builder(DataFromRequest data){
            this.data = data;
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
