package dw.wholesale_company.Repository;

import dw.wholesale_company.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("select e1 from Employee e1 order by e1.hireDate desc limit 1")
    Employee getNewestEmployee();
}
