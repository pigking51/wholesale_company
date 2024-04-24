package dw.wholesale_company.Controller;

import dw.wholesale_company.Model.Customer;
import dw.wholesale_company.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RequestMapping : 이거쓰면 맨 위에 주소적어두고 아래에 일일히 적어두지 않아도 됨(prefix)
@RestController
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>>  getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(),
                HttpStatus.OK);

    }

    @GetMapping("/customers/upavgmileage")
    public ResponseEntity<List<Customer>> getCustomersIfMoreAvgMileage(){
        return new ResponseEntity<>(customerService.getCustomersIfMoreAvgMileage(),
        HttpStatus.OK);
    }




}
