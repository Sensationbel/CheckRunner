package by.bulaukin.shop_receipt.repository.products;

import by.bulaukin.shop_receipt.model.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GettingProductsEntityImpl implements GettingProductsEntity {

    private final ProductsEntityRepo pr;
    @Override
    public Products getProductsById(Integer id) {
        return pr
                .getProductsById(id)
                .orElseThrow(() -> new NullPointerException("Product by id " + id + " is not found."));
    }
}
