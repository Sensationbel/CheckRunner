package by.bulaukin.shop_receipt.entity_to_dto;

import by.bulaukin.shop_receipt.dto_service.ProductsToProductsDtoServices;
import by.bulaukin.shop_receipt.dto_service.dto.ProductsDto;
import by.bulaukin.shop_receipt.model.Cards;
import by.bulaukin.shop_receipt.model.Products;
import by.bulaukin.shop_receipt.pars_data.DataFromRequest;
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

    public ResultEntityToDto getResult(DataFromRequest data) {
        ResultEntityToDto result = new ResultEntityToDto();
        addProductsDtoToResult(data, result);

        addCardDiscountToResult(data, result);
        return result;
    }

    private void addCardDiscountToResult(DataFromRequest data, ResultEntityToDto result) {
        try {
            result.setCardDiscount(getCards(data.getCardNumber()).getDiscount());
        } catch (NullPointerException e) {
            log.info("Card by cards number {} is not found", data.getCardNumber());
        } finally {
            if (result.getCardDiscount() == null) {
                result.setCardDiscount((short) 0);
            }
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
