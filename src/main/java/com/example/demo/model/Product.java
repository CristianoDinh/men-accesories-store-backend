package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, unique = true)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_size", nullable = false)
    private String productSize;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "in_stock", nullable = false)
    private Integer inStock;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User admin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category cateId;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "product_order",  // Tên bảng trung gian
//            joinColumns = @JoinColumn(name = "product_id"),  // Khóa ngoại tham chiếu tới bảng Product
//            inverseJoinColumns = @JoinColumn(name = "order_id")  // Khóa ngoại tham chiếu tới bảng Order
//    )
//    private List<Order> orders;

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order_Item> orderItems;  // Liên kết tới Enrollment
}
