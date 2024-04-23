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
@Table(name = "제품")
public class Product {

    @Id
    @Column(name = "제품번호", nullable = false, length = 11)
    private int productId;

    @Column(name = "제품명", nullable = false, length = 50)
    private String productName;

    @Column(name = "포장단위", nullable = false, length = 30)
    private String pkgUnit;

    @Column(name = "단가", nullable = false, length = 11)
    private int unitPrice;

    @Column(name = "재고", nullable = false, length = 11)
    private int inventory;

}
