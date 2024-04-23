package dw.wholesale_company.Service;

import dw.wholesale_company.Model.Customer;
import dw.wholesale_company.Repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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

        for(int i = 0; i < customerRepository.findAll().size(); i++){
            int customer = customerRepository.findAll().get(i).getMileage();
            if(customer > mileageAvg){
                customers.add(customerRepository.findAll().get(i));
            }
        }
        return customers;
    }
}
