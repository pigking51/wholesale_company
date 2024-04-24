package dw.wholesale_company.Controller;

import dw.wholesale_company.Model.Employee;
import dw.wholesale_company.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(),
                HttpStatus.OK);

    }

    @GetMapping("/employees/newest")
    public ResponseEntity<Employee> getNewestEmployee(){
        return new ResponseEntity<>(employeeService.getNewestEmployee(),
                HttpStatus.OK);
    }

    @GetMapping("/employees/hiredate/latest")
    public ResponseEntity<Employee> getEmployeeByHireLatest(){
        return new ResponseEntity<>(employeeService.getEmployeeByHireLatest(),
                HttpStatus.OK);
    }
}
