package dw.wholesale_company.Controller;

import dw.wholesale_company.Model.OrderDetail;
import dw.wholesale_company.Service.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderDetailController {

    OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/orderdetails")
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails(){
        return new ResponseEntity<>(orderDetailService.getAllOrderDetails(),
        HttpStatus.OK);
    }
}
