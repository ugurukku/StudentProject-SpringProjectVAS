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
            sequenceName = "user_id_sequence",
            allocationSize = 1
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

    private String email;

    private String password;

    @Column(name = "is_active")
    private Boolean isActive;

    public User(String fullName, LocalDate age) {
        this.fullName = fullName;
        this.age = age;
    }
}
