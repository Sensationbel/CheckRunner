package by.bulaukin.shop_receipt.repository;

import by.bulaukin.shop_receipt.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepo extends JpaRepository<Products, Integer> {

    List<Products> getAllByIdContaining(List<Integer> list);
}
