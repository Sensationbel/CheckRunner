package by.bulaukin.shop_receipt.entityToDto;

import by.bulaukin.shop_receipt.dtoService.CardsToCardsDtoService;
import by.bulaukin.shop_receipt.dtoService.ProductsToProductsDtoServices;
import by.bulaukin.shop_receipt.dtoService.dto.CardsDto;
import by.bulaukin.shop_receipt.dtoService.dto.ProductsDto;
import by.bulaukin.shop_receipt.model.Cards;
import by.bulaukin.shop_receipt.model.Products;
import by.bulaukin.shop_receipt.parsData.DataFromRequest;
import by.bulaukin.shop_receipt.repository.cards.GettingCards;
import by.bulaukin.shop_receipt.repository.products.GettingProducts;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ResultEntityToDtoService {

    private final GettingProducts gettingProducts;
    private final GettingCards gettingCards;
    private final ProductsToProductsDtoServices productsToProductsDtoServices;
    private final CardsToCardsDtoService cardsToCardsDtoService;

    public ResultEntityToDto getResult(DataFromRequest data){
        ResultEntityToDto result = new ResultEntityToDto();
        data.getItems().forEach((k, v) ->{
            Products products = getProducts(k);
            ProductsDto prodDto = productsToProductsDtoServices
                    .getProductsDto(products, v);
            result.getProductsDtoList().add(prodDto);
        });

        Cards cards = getCards(data.getCardNumber());
        CardsDto cardsDto = cardsToCardsDtoService.getCardsDto(cards);
        result.setCardsDto(cardsDto);

        return result;
    }

    private Products getProducts(Integer productsId) {
            return gettingProducts.getProductsById(productsId);

    }

    private Cards getCards(Integer cardsId) {
        return gettingCards.findCardsByCardNumber(cardsId);
    }


}
