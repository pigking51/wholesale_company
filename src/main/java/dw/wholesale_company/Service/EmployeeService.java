package dw.wholesale_company.Service;

import dw.wholesale_company.Model.Employee;
import dw.wholesale_company.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
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
//            // 직급 = 사원 조건없이 가장 최신 입사자 구하는 코드(결과 똑같음)
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

    // ↑ 람다식으로 표현
    public Employee getEmployeeByHireLatest(){
        return employeeRepository.findAll()
                .stream().filter(a -> a.getPosition().equals("사원"))
                .sorted(Comparator.comparing(Employee::getHireDate).reversed())
                .findFirst().get();
    }
    // sort와 sorted의 차이 : return값을 받지 않느냐 받느냐의 차이
}
