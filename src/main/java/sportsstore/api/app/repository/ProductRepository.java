package sportsstore.api.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sportsstore.api.app.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    Page<Product> findAllByCategoryIgnoreCase(String category, Pageable pageable);
    long countByCategoryIgnoreCase(String category);

    @Query("SELECT DISTINCT category FROM Product ORDER BY category")
    List<String> findDistinctCategory();

    Product findByProductID(int productID);
}