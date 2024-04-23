package dw.wholesale_company.Service;

import dw.wholesale_company.Model.Department;
import dw.wholesale_company.Repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DepartmentService {

    DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
