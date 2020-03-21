package sportsstore.api.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sportsstore.api.app.model.PagingInfo;
import sportsstore.api.app.model.Product;
import sportsstore.api.app.model.ProductsListViewModel;
import sportsstore.api.app.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{page}")
    public ProductsListViewModel getList(@PathVariable("page") int page) {
        var o = new ProductsListViewModel();
        Pageable pageable = PageRequest.of(page - 1, 20, Sort.by("productID").ascending());
        Page<Product> pg = productRepository.findAll(pageable);
        PagingInfo pagingInfo = new PagingInfo();
        pagingInfo.setCurrentPage(page);
        pagingInfo.setItemsPerPage(20);
        pagingInfo.setTotalItems((int) productRepository.count());
        o.setProducts(pg.toList());
        o.setPagingInfo(pagingInfo);

        return o;
    }

    @GetMapping("/{category}/{page}")
    public ProductsListViewModel getList(@PathVariable("category") String category, @PathVariable("page") int page) {
        var o = new ProductsListViewModel();
        Pageable pageable = PageRequest.of(page - 1, 20, Sort.by("productID").ascending());
        Page<Product> pg = null;
        long count = 0;
        if (category == null) {
            pg = productRepository.findAll(pageable);
            count = productRepository.count();
        }

        else {
            pg = productRepository.findAllByCategoryIgnoreCase(category, pageable);
            count = productRepository.countByCategoryIgnoreCase(category);
        }
        
        PagingInfo pagingInfo = new PagingInfo();
        pagingInfo.setCurrentPage(page);
        pagingInfo.setItemsPerPage(20);
        pagingInfo.setTotalItems(count);
        o.setProducts(pg.toList());
        o.setPagingInfo(pagingInfo);
        o.setCurrentCategory(category);

        return o;
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return productRepository.findDistinctCategory();
    }
}