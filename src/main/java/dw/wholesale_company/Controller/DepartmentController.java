package dw.wholesale_company.Controller;

import dw.wholesale_company.Model.Department;
import dw.wholesale_company.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        return new ResponseEntity<>(departmentService.getAllDepartments(),
                HttpStatus.OK);
    }
}
