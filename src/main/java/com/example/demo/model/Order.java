package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, unique = true)
    private Long orderId;

    @Column(name = "status", nullable = false, unique = true)
    private String status;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    @Column(name = "consumer_id", nullable = false)
    private User consumerId;

//    @ManyToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Product> products;

    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order_Item> orderItems;  // Liên kết tới Enrollment
}
