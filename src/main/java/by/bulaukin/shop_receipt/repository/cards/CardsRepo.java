package by.bulaukin.shop_receipt.repository.cards;

import by.bulaukin.shop_receipt.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardsRepo extends JpaRepository<Cards, Integer> {

    Optional<Cards> findCardsByCardNumber(Integer cardNumber);
}
