package dw.wholesale_company.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "마일리지등급")
public class Mileage {
    @Id
    @Column(name = "등급명", nullable = false, length = 50 )
    private String mileageGrade;
    @Column(name = "하한마일리지", nullable = false, length = 11)
    private int lowLimit;
    @Column(name = "상한마일리지", nullable = false, length = 11)
    private int highLimit;

}
