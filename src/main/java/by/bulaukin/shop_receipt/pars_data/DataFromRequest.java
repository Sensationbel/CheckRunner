package by.bulaukin.shop_receipt.pars_data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
@Setter
public class DataFromRequest {

    private final Map<Integer,Integer> items = new HashMap<>();
    private Integer cardNumber;

    @Service
    @RequiredArgsConstructor
    public static class DataBuilder {

        private final DataFromRequest data;

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
