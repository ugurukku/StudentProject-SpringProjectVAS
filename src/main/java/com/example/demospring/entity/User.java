package com.example.demospring.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity(name = "istifadeciler")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tam_ad")
    private String fullName;

    @Column(name = "tevellud")
    private LocalDate age;

    public User(String fullName, LocalDate age) {
        this.fullName = fullName;
        this.age = age;
    }
}
