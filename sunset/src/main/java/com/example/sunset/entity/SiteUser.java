package com.example.sunset.entity;
import com.example.sunset.config.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SiteUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name; //이름

    @Column(nullable = false, length = 50, unique = true)
    private String username; //아이디

    @Column(nullable = false, length = 100)
    private String password;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;
}
