package by.bulaukin.shop_receipt.repository.products;

import by.bulaukin.shop_receipt.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepo extends JpaRepository<Products, Integer> {

    Optional<Products> getProductsById(Integer id);
}
