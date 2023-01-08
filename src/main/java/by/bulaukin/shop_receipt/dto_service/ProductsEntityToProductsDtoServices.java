package by.bulaukin.shop_receipt.dto_service;

import by.bulaukin.shop_receipt.dto_service.dto.ProductsDto;
import by.bulaukin.shop_receipt.model.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductsEntityToProductsDtoServices {

    public ProductsDto getProductsDto(Products product, int queItems){

        ProductsDto dto = new ProductsDto();
        dto.setPrice(product.getPrice());
        dto.setItems(product.getItems());
        dto.setOnSale(product.getIsOnSale() == 1 ? true : false);
        dto.setQuantity(queItems);
        dto.setItemsTotalPrice(Math.ceil(product.getPrice() * queItems * 100)/100);
        return dto;
    }
}
