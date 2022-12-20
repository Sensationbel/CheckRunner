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
import by.bulaukin.shop_receipt.repository.products.ProductsRepo;
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

    public ResultEntityToDto getResult(DataFromRequest data) {
        ResultEntityToDto result = new ResultEntityToDto();
        addProductsDtoToResult(data, result);
        addCardsDtoToResult(data, result);
        return result;
    }

    private void addCardsDtoToResult(DataFromRequest data, ResultEntityToDto result) {
        try {
            Cards cards = getCards(data.getCardNumber());
            CardsDto cardsDto = cardsToCardsDtoService.getCardsDto(cards);
            result.setCardDiscount(cardsDto.getDiscount());
        } catch (NullPointerException e) {
            log.info("Card is not found");
        }
    }

    private void addProductsDtoToResult(DataFromRequest data, ResultEntityToDto result) {
        data.getItems().forEach((k, v) -> {
            try {
                Products prod = getProducts(k);
                ProductsDto prodDto = productsToProductsDtoServices
                        .getProductsDto(prod, v);
                result.getProductsDtoList().add(prodDto);
            } catch (NullPointerException e) {
                log.info("Item by id {} is not found", k);
            }
        });
    }

    private Products getProducts(Integer productsId) {
        return gettingProducts.getProductsById(productsId);

    }

    private Cards getCards(Integer cardsId) {
        return gettingCards.findCardsByCardNumber(cardsId);
    }


}
