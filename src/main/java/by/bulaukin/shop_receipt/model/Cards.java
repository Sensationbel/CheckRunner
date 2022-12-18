package by.bulaukin.shop_receipt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "card_number")
    private Integer cardNumber;
    @Column(name = "discount")
    private Short discount;

}
