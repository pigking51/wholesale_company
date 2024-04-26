package dw.wholesale_company.service;

import dw.wholesale_company.Exception.ResourceNotFoundException;
import dw.wholesale_company.Model.Customer;
import dw.wholesale_company.Model.Employee;
import dw.wholesale_company.Model.Order;
import dw.wholesale_company.Repository.CustomerRepository;
import dw.wholesale_company.Repository.EmployeeRepository;
import dw.wholesale_company.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TestService {

    EmployeeRepository employeeRepository;

    CustomerRepository customerRepository;

    OrderRepository orderRepository;

    public TestService(EmployeeRepository employeeRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    //1. 도시이름(city)을 매개변수로 받아 그 도시출신의 사원 정보를 보이시오.
    public List<Employee> getEmployeeByCity(String city) {
        List<Employee> employees = employeeRepository.findAll();

//        List<Employee> newEmployees = new ArrayList<>();
//        for(int i = 0; i < employees.size(); i++){
//            if(employees.get(i).getCity().equals(city)){
//                newEmployees.add(employees.get(i));
//            }
//        }
//            return newEmployees;

        return employees.stream().filter(employee -> employee.getCity().equals(city))
                .collect(Collectors.toList());
    }

    //2. 주문번호를 매개변수(orderId)로 받아 주문한 고객의 정보를 보이시오.
    public Customer getCustomerByOrderId(String orderId) {
        Optional<Order> orders = orderRepository.findById(orderId);
            if(orders.isEmpty()){
                throw new ResourceNotFoundException("Order", "ID", orderId);
            }
              return orders.get().getCustomer();
    }

    //3. 주문년도(orderYear)를 매개변수로 받아 그 해의 주문건수(int)를 보이시오.
    public int getOrderNumByOrderYear(int orderYear) {
        List<Order> orders = orderRepository.findAll();
        return (int)orders.stream().filter(order -> order.getOrderDate().getYear() == orderYear).count();

//        int count = 0;
//
//        for(int i = 0; i < orders.size(); i++){
//
//            if(orders.get(i).getOrderDate().getYear() == orderYear){
//                count++;
//            }
//        }
//        return count;
    }

    //4. 직위(position)와 나이대(year)를 매개변수로 받아 해당정보에 맞는 사원들의 정보를 보이시오.
    // 예를 들어 20대는 매개변수 year=20 이고 나이가 20살이상 30살미만을 의미함.
    // 나이계산은 (올해 - 태어난해)로 계산.
    public List<Employee> getEmployeeByPositionAndYear(String position, int year) {
        List<Employee> employees = employeeRepository.findAll();
        List<Employee> newEmployee = new ArrayList<>();
        List<Employee> newEmployees = new ArrayList<>();

//        for(int i = 0; i< employees.size(); i++){
//            if(employees.get(i).getPosition().equals(position)){
//                newEmployee.add(employees.get(i));
//            }
//        }
//
//        for(int i = 0; i < newEmployee.size(); i++){
//            int old = LocalDate.now().getYear() - newEmployee.get(i).getBirthDate().getYear();
//            if(old >= year && old < year+10 ){
//                newEmployees.add(newEmployee.get(i));
//            }
//        }
//        return newEmployees;

        return employees.stream().filter(employee -> employee.getPosition().equals(position))
                                 .filter(employee -> LocalDate.now().getYear() - employee.getBirthDate().getYear() >= year
                                 && LocalDate.now().getYear() -  employee.getBirthDate().getYear() < year+10)
                                .collect(Collectors.toList());
    }
}
