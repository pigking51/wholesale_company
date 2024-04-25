package dw.wholesale_company.Service;

import dw.wholesale_company.Model.Product;
import dw.wholesale_company.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    // 재고가 n개 미만인 제품정보
    public List<Product> getProductLess(int num){
        List<Product> productList = productRepository.findAll();
        return productList.stream().filter(a -> a.getInventory() < num)
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByName(){
        List<Product> products = productRepository.findAll();
        return products.stream().filter(a -> a.getProductName().contains("주스"))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByCallName(String product){
        List<Product> products = productRepository.findAll();
        return products.stream().filter(a -> a.getProductName().contains(product))
                .collect(Collectors.toList());


//        // 람다식으로 안했을 경우
//        List<Product> productList = new ArrayList<>();
//        for(int i = 0 ; i < products.size(); i++){
//            if(products.get(i).getProductName().contains(product)){
//                productList.add(products.get(i));
//            }
//        }
//        return productList;

    }

    public List<Product> getProductsByBetweenPrice(){
        List<Product> products = productRepository.findAll();
        return products.stream().filter(a -> a.getUnitPrice() >= 5000 && a.getUnitPrice() <= 10000)
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByBetweenCallPrice(int lowLimit, int highLimit){
        List<Product> products = productRepository.findAll();
        return products.stream().filter(a -> a.getUnitPrice() >= lowLimit && a.getUnitPrice() <= highLimit)
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByPDNum(int[] arr){
        List<Product> products = productRepository.findAll();
        List<Product> productList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            productList.add(products.get(num - 1));
        }
        return productList;
    }

    public List<Product> getProductsByPDsNum(int[] arr){
        List<Product> products = productRepository.findAll();

        return products.stream().filter(a -> a.getProductId() == arr[0] ||
                       a.getProductId() == arr[1] ||
                       a.getProductId() == arr[2] ||
                       a.getProductId() == arr[3] ||
                       a.getProductId() == arr[4] ||
                       a.getProductId() == arr[5] )
               .collect(Collectors.toList());

    }

    public List<Product> getProductsByIdWithList(List<Long> idList){
        List<Product> productList = productRepository.findAll();
//        List<Product> newProducts = new ArrayList<>();
//        for (int i = 0; i < idList.size(); i++ ){
//            for(int j = 0; j < idList.size(); i++){
//                if(productList.get(i).getProductId() == idList.get(i)){
//                    newProducts.add(productList.get(i));
//                }
//            }
//        }
//        return newProducts;
        return productList.stream().filter(a -> idList.contains(a.getProductId()))
                .collect(Collectors.toList());
    }
    
    // 제품 재고금액이 높은 상위 10개 제품
    // (재고금액 = 단가(unitprice)* 재고수량(inventory))
    public List<Product> getProductByTop10Price(){
        List<Product> products = productRepository.findAll();
        List<Product> newProducts = new ArrayList<>();

          return products.stream().sorted(Comparator.comparing((Product product) -> product.getUnitPrice()*product.getInventory()).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    public List<Product> getProductByTopLimitPrice(int limit){
        List<Product> products = productRepository.findAll();
        List<Product> newProducts = new ArrayList<>();

        return products.stream().sorted(Comparator.comparing((Product product) -> product.getUnitPrice()*product.getInventory()).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }
}
