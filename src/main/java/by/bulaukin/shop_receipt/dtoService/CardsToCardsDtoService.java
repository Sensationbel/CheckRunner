package by.bulaukin.shop_receipt.dtoService;

import by.bulaukin.shop_receipt.dtoService.dto.CardsDto;
import by.bulaukin.shop_receipt.model.Cards;
import org.springframework.stereotype.Component;

@Component
public class CardsToCardsDtoService {

    public CardsDto getCardsDto(Cards card){
        CardsDto dto = new CardsDto();
        dto.setCardsNumber(card.getCardNumber());
        dto.setDiscount(card.getDiscount());
        return dto;
    }
}
