package dw.wholesale_company.Controller;

import dw.wholesale_company.Model.Order;
import dw.wholesale_company.Service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/orders/afterdate")
    public ResponseEntity<List<Order>> getOrderAfterOrderDate(){
        return new ResponseEntity<>(orderService.getOrderAfterOrderDate(),
                HttpStatus.OK);
    }


}
