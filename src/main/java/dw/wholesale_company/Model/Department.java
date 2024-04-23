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
@Table(name = "부서")
public class Department {
    @Id
    @Column(name = "부서번호", nullable = false, length = 2)
    private String departId;

    @Column(name = "부서명", nullable = false, length =20)
    private String departName;
}
