package dw.wholesale_company.Controller;

import dw.wholesale_company.Model.Customer;
import dw.wholesale_company.Model.Mileage;
import dw.wholesale_company.Service.MileageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MileageController {

    MileageService mileageService;

    public MileageController(MileageService mileageService) {
        this.mileageService = mileageService;
    }

    @GetMapping("/mileages")
    public ResponseEntity<List<Mileage>> getAllMileages(){
        return new ResponseEntity<>(mileageService.getAllMileages(),
                HttpStatus.OK);
    }


}
