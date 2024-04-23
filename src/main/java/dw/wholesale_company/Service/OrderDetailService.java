package dw.wholesale_company.Service;

import dw.wholesale_company.Model.OrderDetail;
import dw.wholesale_company.Repository.OrderDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderDetailService {

    OrderDetailRepository orderDetailRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public List<OrderDetail> getAllOrderDetails(){
        return orderDetailRepository.findAll();
    }
}
