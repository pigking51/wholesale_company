package dw.wholesale_company.Controller;

import dw.wholesale_company.Model.Customer;
import dw.wholesale_company.Model.Order;
import dw.wholesale_company.Service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(),
                HttpStatus.OK);
    }

    // 주문일이 2021년 5월 1일 이후인 주문 정보 얻기(특정날짜 이후)
    // → 이거 결과물이 200개 넘게나와서 검토 어려우니 앞이나 뒤에 몇개 잘라서 그때 기준
    //   정보로 확인해서 제대로 작동되는지 확인해야될듯
    @GetMapping("/orders/afterdate")
    public ResponseEntity<List<Order>> getOrderAfterOrderDate(){
        return new ResponseEntity<>(orderService.getOrderAfterOrderDate(),
                HttpStatus.OK);
    }

    // 특정날짜 이후로 받으려면
    // @GetMapping("/orders/date/after/{date}")
//     public ResponseEntity<List<Order>> getOrderAfterOrderDate2(@PathVariable LocalDate date){
//        return new ResponseEntity<>(orderService.getOrderAfterOrderDate2(),
//                HttpStatus.OK);
//    }

    // 특정 날짜에 주문한 고객정보(아래 2개로 하면 정보가 나오기는 하는데
    // 주문테이블 전체가 나오기에 정답은 아님)
    @GetMapping("/orders/ordercustomer")
    public ResponseEntity<List<Order>> getCustomersBySomeDate(){
        return new ResponseEntity<>(orderService.getCustomersBySomeDate(),
                HttpStatus.OK);
    }

    @GetMapping("/orders/ordercustomer/{date}")
    public ResponseEntity<List<Order>> getCustomersBySomeDates(@PathVariable LocalDate date){
        return new ResponseEntity<>(orderService.getCustomersBySomeDates(date),
                HttpStatus.OK);
    }
    // 특정 날짜에 주문한 고객정보
    @GetMapping("/orders/ordercustomerss/{date}")
    public ResponseEntity<List<Customer>> getCustomersBySomeDatess(@PathVariable LocalDate date){
        return new ResponseEntity<>(orderService.getCustomersBySomeDatess(date),
                HttpStatus.OK);
    }


}
