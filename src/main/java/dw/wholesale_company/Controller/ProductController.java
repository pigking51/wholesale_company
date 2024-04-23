package dw.wholesale_company.Controller;

import dw.wholesale_company.Model.Product;
import dw.wholesale_company.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),
                HttpStatus.OK);
    }

    @GetMapping("/products/lessinven")
    public ResponseEntity<List<Product>> getProductLess50(){
        return new ResponseEntity<>(productService.getProductLess50(),
                HttpStatus.OK);
    }
}

