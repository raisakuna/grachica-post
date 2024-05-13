package com.graphica.restapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="post_title", nullable = false)
    private String title;

    @Column(name="post_description", nullable = false)
    private String description;

    @Column(name="post_content", nullable = false)
    private String content;
}
