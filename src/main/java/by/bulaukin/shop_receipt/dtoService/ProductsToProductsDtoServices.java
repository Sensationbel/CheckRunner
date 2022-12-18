package by.bulaukin.shop_receipt.dtoService;

import by.bulaukin.shop_receipt.dtoService.dto.ProductsDto;
import by.bulaukin.shop_receipt.model.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductsToProductsDtoServices {

    public ProductsDto getProductsDto(Products product, int countItems){
        ProductsDto dto = new ProductsDto();
        dto.setPrice(product.getPrice());
        dto.setItems(product.getItems());
        dto.setCount(countItems);
        return dto;
    }
}
