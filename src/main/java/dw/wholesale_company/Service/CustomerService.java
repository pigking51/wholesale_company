package dw.wholesale_company.Service;

import dw.wholesale_company.Model.Customer;
import dw.wholesale_company.Model.Order;
import dw.wholesale_company.Repository.CustomerRepository;
import dw.wholesale_company.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {

    CustomerRepository customerRepository;

    OrderRepository orderRepository;

    public CustomerService(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    
    
    // 4. 고객 전체의 평균마일리지보다 평균마일리지가 큰 고객 정보
    public List<Customer> getCustomersIfMoreAvgMileage(){
        List<Customer> customers = new ArrayList<>();
        int mileageSum = customerRepository.findAll().get(0).getMileage();
        for(int i = 0; i < customerRepository.findAll().size(); i++){
            mileageSum = customerRepository.findAll().get(i).getMileage() + mileageSum;
        }
        int mileageSumR = mileageSum - customerRepository.findAll().get(0).getMileage();

        int mileageAvg = mileageSumR / customerRepository.findAll().size();
        // ↑ 여기서는 int로 계속 처리했지만, 평균을 선언할때는 Double로 사용하기

        for(int i = 0; i < customerRepository.findAll().size(); i++){
            int customer = customerRepository.findAll().get(i).getMileage();
            if(customer > mileageAvg){
                customers.add(customerRepository.findAll().get(i));
            }
        }
        return customers;
    }

    public List<Customer> getCustomerWithHighMileThanAvg(){
        List<Customer> customers = customerRepository.findAll();
        int sum = 0;
        for(int i = 0; i < customers.size(); i++){
            sum = sum + customers.get(i).getMileage();
        }
        Double avg = (double)sum / (double)customers.size();
        return customers.stream().filter(a -> a.getMileage() > avg)
                .collect(Collectors.toList());
    }




}
