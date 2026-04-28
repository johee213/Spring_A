package com.example.entity;
import com.example.config.Role;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; //기본키

    @Column(nullable = false)
    private String userName; //이름

    @Column(nullable = false)
    private String password;

    private String phone;

    @Column(nullable = false)
    private String birth;

    @Enumerated(EnumType.STRING)
    private Role role;
}
