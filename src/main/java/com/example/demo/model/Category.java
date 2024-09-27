package com.example.demo.model;

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
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Integer cateId;

    @Column(name = "category_name", nullable = false)
    private String cateName;

    @OneToMany(mappedBy = "cateId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products;
}
