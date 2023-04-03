package com.example.demospring.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name = "paylashimlar")
public class Blog {

    @Id
    @SequenceGenerator(
            name = "blog_id_sequence",
            sequenceName = "blog_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "blog_id_sequence"
    )
    @Column(nullable = false)
    Long id;

    @Column(name = "blog_bashligi")
    String header;

    @Column(name = "blog_kontenti")
    String content;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
}
