package com.example.demo.model;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id", nullable = false, unique = true)
    private Long blogId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "blog_image", nullable = false)
    private String blogImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id") //FK REFERENCES to users table PrimaryKey
    private User authorId;
}
