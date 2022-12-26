package by.bulaukin.shop_receipt.pars_data.data;

import by.bulaukin.shop_receipt.pars_data.data.ItemsFromRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class DataFromRequest {

    private List<ItemsFromRequest> items = new ArrayList<>();
    private Integer cardNumber;

//    @Service
//    @RequiredArgsConstructor
//    public static class DataBuilder {
//
//        private final DataFromRequest data;
//
//        public DataBuilder addItems(Integer itemsId, Integer itemsCount) {
//            this.data.items.put(itemsId, itemsCount);
//            return this;
//        }
//
//        public DataBuilder addCardNumber(Integer cardNumber) {
//            this.data.cardNumber = cardNumber;
//            return this;
//        }
//
//        public DataFromRequest build() {
//            return data;
//        }
//
//    }
}
