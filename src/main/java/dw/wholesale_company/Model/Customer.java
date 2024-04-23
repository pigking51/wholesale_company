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
@Table(name = "고객")
public class Customer {

    @Id
    @Column(name = "고객번호", nullable = false, length = 5)
    private String customerId;

    @Column(name = "고객회사명", nullable = false, length = 30)
    private String customerName;

    @Column(name = "담당자명", nullable = false, length = 20)
    private String cutomerEmployee;

    @Column(name = "담당자직위", nullable = false, length = 20)
    private String employeeTitle;

    @Column(name = "주소", nullable = false, length = 50)
    private String address;

    @Column(name = "도시", nullable = false, length = 20)
    private String city;

    @Column(name = "지역", nullable = false, length = 20)
    private String area;

    @Column(name = "전화번호", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "마일리지", nullable = false, length = 11)
    private int mileage;

}
