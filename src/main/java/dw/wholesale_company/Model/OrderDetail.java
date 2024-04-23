package dw.wholesale_company.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "주문세부")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "주문세부번호")
    private long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "주문번호")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "제품번호")
    private Product product;

    @Column(name = "단가", nullable = false, length = 11)
    private int unitPrice;

    @Column(name = "주문수량", nullable = false, length = 11)
    private int orderQuantity;

    @Column(name = "할인율", nullable = false)
    private float discountRate;

}
