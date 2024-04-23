package dw.wholesale_company.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "주문")
public class Order {

    @Id
    @Column(name = "주문번호", nullable = false, length = 5)
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "고객번호")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "사원번호")
    private Employee employee;

    @Column(name = "주문일", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "요청일", nullable = false)
    private LocalDateTime requestDate;

    @Column(name = "발송일", nullable = false)
    private LocalDateTime shippingDate;

}
