package dw.wholesale_company.Service;

import dw.wholesale_company.Model.Customer;
import dw.wholesale_company.Model.Order;
import dw.wholesale_company.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        LocalDate odate = LocalDate.of(2021,5,1);
        for(int i = 0; i < orderRepository.findAll().size(); i++){
            LocalDate order = orderRepository.findAll().get(i).getOrderDate();
            if(order.isAfter(odate)){
                orders.add(orderRepository.findAll().get(i));
            }
        }
        return orders;
    }
//    람다식을 이용한 해결방법
    // public List<Order> getOrderAfterOrderDate2(LocalDate date){
    //      List<Order> orders = orderRepository.findAll();
    //      return orders.stream().filter(a -> a.getOrderDate().compareTo(date > 0)
    //      .collect(Collectors.toList())
    //  }


    public List<Order> getCustomersBySomeDate(){
        List<Order> customers = orderRepository.findAll();
        LocalDate thatDay = LocalDate.of(2020,4,9);
        return customers.stream().filter(a -> a.getOrderDate().compareTo(thatDay) == 0)
               .collect(Collectors.toList());
    }

    public List<Order> getCustomersBySomeDates(LocalDate date){
        List<Order> customers = orderRepository.findAll();
        return customers.stream().filter(a -> a.getOrderDate().compareTo(date) == 0)
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomersBySomeDatess(LocalDate orderDate){
        List<Order> orders = orderRepository.findByOrderDate(orderDate);
        return orders.stream().map(a -> a.getCustomer())
                .collect(Collectors.toList());
    }

}
