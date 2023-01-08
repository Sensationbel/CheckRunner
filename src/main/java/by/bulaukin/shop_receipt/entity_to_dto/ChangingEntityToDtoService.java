package by.bulaukin.shop_receipt.entity_to_dto;

import by.bulaukin.shop_receipt.dto_service.ProductsEntityToProductsDtoServices;
import by.bulaukin.shop_receipt.dto_service.dto.ProductsDto;
import by.bulaukin.shop_receipt.model.Cards;
import by.bulaukin.shop_receipt.model.Products;
import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import by.bulaukin.shop_receipt.pars_data.data.ItemsFromRequest;
import by.bulaukin.shop_receipt.repository.cards.GettingCardsEntity;
import by.bulaukin.shop_receipt.repository.products.GettingProductsEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Log4j2
public class ChangingEntityToDtoService {

    private final GettingProductsEntity productsEntity;
    private final GettingCardsEntity cardsEntity;
    private final ProductsEntityToProductsDtoServices dtoServices;

    public ResultChangingEntityToDto getResult(RequestsParsingResult data) {

        ResultChangingEntityToDto result = new ResultChangingEntityToDto();
        addProductsDtoToResult(data, result);
        addCardDiscountToResult(data, result);
        return result;
    }

    private void addCardDiscountToResult(RequestsParsingResult data, ResultChangingEntityToDto result) {

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

    private void addProductsDtoToResult(RequestsParsingResult data, ResultChangingEntityToDto result) {
        Map<Integer, Integer> uniqItems = getUniqItems(data.getItemsList());

        uniqItems.forEach((id, quantity) -> {
            try {
                Products prod = getProducts(id);
                ProductsDto prodDto = dtoServices
                        .getProductsDto(prod, quantity);
                result.getProductsDtoList().add(prodDto);
            } catch (NullPointerException e) {
                log.info("Item by id {} is not found", id);
            }
        });
    }

    private Map<Integer, Integer> getUniqItems(List<ItemsFromRequest> items) {
        Map<Integer, Integer> uniqItems = new HashMap<>();

        items.forEach(item ->{
            int itemsCount = uniqItems.getOrDefault(item.getItemsId(), 0);
            uniqItems.put(item.getItemsId(), item.getItemsQua() + itemsCount);
        });
        return uniqItems;
    }

    private Products getProducts(Integer productsId) {
        return productsEntity.getProductsById(productsId);
    }

    private Cards getCards(Integer cardsId) {
        return cardsEntity.findCardsByCardNumber(cardsId);
    }
}
