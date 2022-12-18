package by.bulaukin.shop_receipt.repository.cards;

import by.bulaukin.shop_receipt.model.Cards;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GettingCardsService implements GettingCards{

    private final CardsRepo cr;

    @Override
    public Cards findCardsByCardNumber(Integer cardNumber) {
        return cr
                .findCardsByCardNumber(cardNumber)
                .orElseThrow(()-> new NullPointerException("Cards by card number " + cardNumber + " is not found."));
    }
}
