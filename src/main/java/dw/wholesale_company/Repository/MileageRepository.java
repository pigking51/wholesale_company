package dw.wholesale_company.Repository;

import dw.wholesale_company.Model.Mileage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MileageRepository extends JpaRepository<Mileage, String> {
}
