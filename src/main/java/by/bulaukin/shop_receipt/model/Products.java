package by.bulaukin.shop_receipt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String items;
    private Double price;
    @Column(name = "is_on_sale")
    private Short isOnSale;


}
