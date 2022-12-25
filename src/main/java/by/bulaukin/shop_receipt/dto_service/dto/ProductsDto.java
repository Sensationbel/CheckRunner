package by.bulaukin.shop_receipt.dto_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDto {

    private String items;
    private double price;
    private int count;
    private double itemsTotalPrice;
    private boolean isOnSale;
}
