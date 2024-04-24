package dw.wholesale_company.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "사원")
public class Employee {

    @Id
    @Column(name = "사원번호", nullable = false, length = 3)
    private String employeeId;

    @Column(name = "이름", nullable = false, length = 20)
    private String name;

    @Column(name = "영문이름", nullable = false, length = 20)
    private String englishName;

    @Column(name = "직위", nullable = false, length = 10)
    private String position;

    @Column(name = "성별", nullable = false, length = 2)
    private String gender;

    @Column(name = "생일", nullable = false)
    private LocalDate birthDate;

    @Column(name = "입사일", nullable = false)
    private LocalDate hireDate;

    @Column(name = "주소", nullable = false, length = 50)
    private String address;

    @Column(name = "도시", nullable = false, length = 20)
    private String city;

    @Column(name = "지역", nullable = false, length = 20)
    private String area;

    @Column(name = "집전화", nullable = false, length = 20)
    private String telephoneNo;

    @Column(name = "상사번호", nullable = false, length = 3)
    private String managerId;

    @ManyToOne
    @JoinColumn(name = "부서번호")
    private Department department;

}
