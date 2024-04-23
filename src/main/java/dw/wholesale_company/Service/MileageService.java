package dw.wholesale_company.Service;

import dw.wholesale_company.Model.Mileage;
import dw.wholesale_company.Repository.MileageRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MileageService {

    MileageRepository mileageRepository;

    public MileageService(MileageRepository mileageRepository) {
        this.mileageRepository = mileageRepository;
    }

    public List<Mileage> getAllMileages(){
        return mileageRepository.findAll();
    }
}
