package dw.wholesale_company.Service;

import dw.wholesale_company.Model.Order;
import dw.wholesale_company.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderService {

    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public List<Order> getOrderAfterOrderDate(){
        List<Order> orders = new ArrayList<>();
        LocalDateTime odate = LocalDateTime.of(2021,5,1,0,0);
        for(int i = 0; i < orderRepository.findAll().size(); i++){
            LocalDateTime order = orderRepository.findAll().get(i).getOrderDate();
            if(order.isAfter(odate)){
                orders.add(orderRepository.findAll().get(i));
            }
        }
        return orders;
    }

}
