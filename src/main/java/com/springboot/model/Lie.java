package com.springboot.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "lies")
public class Lie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content", length = 500)
    private String content;
}
