package dw.wholesale_company.Controller;

import dw.wholesale_company.Model.Product;
import dw.wholesale_company.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    // ↑ 특정날짜 이후로 받으려면
    @GetMapping("/products/lessinven/{num}")
    public ResponseEntity<List<Product>> getProductLess(@PathVariable int num){
        return new ResponseEntity<>(productService.getProductLess(num),
                HttpStatus.OK);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> getProductsByName(){
        return new ResponseEntity<>(productService.getProductsByName(),
                HttpStatus.OK);
    }

    @GetMapping("/products/search/{product}")
    public ResponseEntity<List<Product>> getProductsByCallName(@PathVariable String product){
        return new ResponseEntity<>(productService.getProductsByCallName(product),
                HttpStatus.OK);
    }

    @GetMapping("/products/betweenprice")
    public ResponseEntity<List<Product>> getProductsByBetweenPrice(){
        return new ResponseEntity<>(productService.getProductsByBetweenPrice(),
                HttpStatus.OK);
    }
    @GetMapping("/products/betweenprice/{lowLimit}/{highLimit}")
    public ResponseEntity<List<Product>> getProductsByBetweenCallPrice(@PathVariable int lowLimit
                                                                        ,@PathVariable int highLimit){
        return new ResponseEntity<>(productService.getProductsByBetweenCallPrice(lowLimit, highLimit),
                HttpStatus.OK);
    }
    // @GetMapping("/products/betweenprice/") 처럼 주소값에 입력값이 안나오게 하고싶은 경우
    // @PathVariable 말고 @RequestParam를 적어주고 주소 입력할때는 주소?변수로 썼던 값 = 넣을 값 
    // 이런 식으로 입력해줌
    
    // 제품번호가 1,2,4,7,11,20인 제품의 모든 정보를 보이시오
    // → postman에서 배열형태로 요청함 [1,2,4,7,11,20]형태로 요청

    @PostMapping("/products/findproductsbyarr")
    public ResponseEntity<List<Product>> getProductsByPDNum(@RequestBody int[] arr){
        return new ResponseEntity<>(productService.getProductsByPDNum(arr),
                HttpStatus.OK);
    }

    @PostMapping("/products/findproductsbyarrs")
    public ResponseEntity<List<Product>> getProductsByPDsNum(@RequestBody int[] arr){
        return new ResponseEntity<>(productService.getProductsByPDsNum(arr),
                HttpStatus.OK);
    }

    @PostMapping("/products/idList")
    public ResponseEntity<List<Product>> getProductsByIdWithList(@RequestBody List<Long> idList){
        return new ResponseEntity<>(productService.getProductsByIdWithList(idList),
                HttpStatus.OK);
    }

    @GetMapping("/products/producttop10")
    public ResponseEntity<List<Product>> getProductByTop10Price(){
        return new ResponseEntity<>(productService.getProductByTop10Price(),
                HttpStatus.OK);
    }
}

