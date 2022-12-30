package by.bulaukin.shop_receipt.repository.cards;

import by.bulaukin.shop_receipt.model.Cards;

public interface GettingCardsEntity {

    Cards findCardsByCardNumber(Integer cardNumber);
}
