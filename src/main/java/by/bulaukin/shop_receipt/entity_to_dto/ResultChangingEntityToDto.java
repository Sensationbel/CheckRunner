package by.bulaukin.shop_receipt.entity_to_dto;

import by.bulaukin.shop_receipt.dto_service.dto.ProductsDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResultChangingEntityToDto {

    private List<ProductsDto> productsDtoList = new ArrayList<>();
    private Short cardDiscount;
}
