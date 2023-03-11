package com.example.demospring.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity(name = "istifadeciler")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private Long id;

    @Column(name = "tam_ad")
    private String fullName;

    @Column(name = "tevellud")
    private LocalDate age;

    public User(String fullName, LocalDate age) {
        this.fullName = fullName;
        this.age = age;
    }
}
