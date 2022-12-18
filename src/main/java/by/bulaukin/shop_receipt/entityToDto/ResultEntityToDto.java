package by.bulaukin.shop_receipt.entityToDto;

import by.bulaukin.shop_receipt.dtoService.dto.CardsDto;
import by.bulaukin.shop_receipt.dtoService.dto.ProductsDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResultEntityToDto {

    private List<ProductsDto> productsDtoList = new ArrayList<>();
    private CardsDto cardsDto;
}
