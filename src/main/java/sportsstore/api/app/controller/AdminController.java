package sportsstore.api.app.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sportsstore.api.app.model.Product;
import sportsstore.api.app.repository.ProductRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getList() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProductByID(@PathVariable("id") int id) {
        return productRepository.findByProductID(id);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable("id") int id, @RequestBody Product product) {
        Product o = productRepository.findByProductID(id);
        if (o == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        o.setCategory(product.getCategory());
        o.setDescription(product.getDescription());
        o.setName(product.getName());
        o.setPrice(product.getPrice());
        productRepository.saveAndFlush(o);

        return ResponseEntity.ok().body(o);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteProduct(@PathVariable("id") int id) {
        Product o = productRepository.findByProductID(id);
        if (o == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        productRepository.deleteById(id);
        HashMap<String, Object> m = new HashMap<>();
        m.put("success", 1);

        return ResponseEntity.ok().body(m);
    }

    @PostMapping("/product-seed")
    public HashMap<String, Object> seedProduct() {
        for (int i = 0; i < 500; i++) {
            Product o = new Product();
            o.setCategory("Soccer");
            o.setDescription(String.format("Product Desc - %d", i));
            o.setName(String.format("Product - %d", i));
            o.setPrice(new BigDecimal(100.0 + i));
            productRepository.saveAndFlush(o);
        }

        HashMap<String, Object> m = new HashMap<>();
        m.put("success", 1);

        return m;
    }
}