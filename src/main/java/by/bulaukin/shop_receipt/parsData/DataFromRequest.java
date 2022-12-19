package by.bulaukin.shop_receipt.parsData;

import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
@ToString
public class DataFromRequest {

    private final Map<Integer,Integer> items = new HashMap<>();
    private Integer cardNumber;

    public static class DataBuilder {

        DataFromRequest data;

        public DataBuilder(DataFromRequest data){
            this.data = data;
        }

        public DataBuilder addItems(Integer itemsId, Integer itemsCount) {
            this.data.items.put(itemsId, itemsCount);
            return this;
        }

        public DataBuilder addCardNumber(Integer cardNumber) {
            this.data.cardNumber = cardNumber;
            return this;
        }

        public DataFromRequest build() {
            return data;
        }

    }
}
