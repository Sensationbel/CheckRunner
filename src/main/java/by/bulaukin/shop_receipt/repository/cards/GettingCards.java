package by.bulaukin.shop_receipt.repository.cards;

import by.bulaukin.shop_receipt.model.Cards;

public interface GettingCards {

    Cards findCardsByCardNumber(Integer cardNumber);
}
