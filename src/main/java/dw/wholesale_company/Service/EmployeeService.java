package dw.wholesale_company.Service;

import dw.wholesale_company.Model.Employee;
import dw.wholesale_company.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // 3. 사원의 직위가 '사원'인 사람들 중에서 가장 최근에 입사한 사원의 정보
//    public Employee getNewestEmployee(){
//        return employeeRepository.getNewestEmployee();
//    }

    public Employee getNewestEmployee(){
               List<Employee> employee = employeeRepository.findAll();
               Employee employee1 = employeeRepository.findAll().get(0);
//
//            for(int i = 0 ; i < employeeRepository.findAll().size() - 1; i++){
//                if(employee.get(i).getHireDate().compareTo(employeeRepository.findAll().get(i+1).getHireDate()) > 0){
//                    employee1 = employeeRepository.findAll().get(i);
//                }
//            }
//        return employee1;
        List<Employee> employeeList = new ArrayList<>();
        for(int i = 0 ; i < employeeRepository.findAll().size(); i++){
            if(Objects.equals(employeeRepository.findAll().get(i).getPosition(), "사원")){
                employeeList.add(employeeRepository.findAll().get(i));
            }
        }

        for(int i = 0; i < employeeList.size() - 1; i++){
            if(employeeList.get(i).getHireDate().compareTo(employeeList.get(i+1).getHireDate()) < 0){
                employee1 = employeeList.get(i+1);
            }
        }
        return employee1;
    }
}
