package by.bulaukin.shop_receipt.repository.products;

import by.bulaukin.shop_receipt.model.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GettingProductsService implements GettingProductsEntity {

    private final ProductsRepo pr;
    @Override
    public Products getProductsById(Integer id) {
        return pr
                .getProductsById(id)
                .orElseThrow(() -> new NullPointerException("Product by id " + id + " is not found."));
    }
}
