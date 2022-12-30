package by.bulaukin.shop_receipt.pars_data.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter
public class RequestsParsingResult {

    private List<ItemsFromRequest> itemsList = new ArrayList<>();
    private Integer cardNumber;

    public List<ItemsFromRequest> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsFromRequest> itemsList) {
        this.itemsList = itemsList;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }
}
