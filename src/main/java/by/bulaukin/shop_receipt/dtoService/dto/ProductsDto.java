package by.bulaukin.shop_receipt.dtoService.dto;

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
