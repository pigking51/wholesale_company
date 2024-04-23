package dw.wholesale_company.Service;

import dw.wholesale_company.Model.Product;
import dw.wholesale_company.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    
    // 2. 제품의 재고가 50개 미만인 제품 정보 얻기
    public List<Product> getProductLess50(){
        List<Product> products = new ArrayList<>();
        for(int i = 0; i < productRepository.findAll().size(); i++){
            if(productRepository.findAll().get(i).getInventory() < 50){
               products.add(productRepository.findAll().get(i));
            }
        }
        return products;
    }
}
