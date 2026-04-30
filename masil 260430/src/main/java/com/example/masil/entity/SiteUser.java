package com.example.masil.entity;

import com.example.masil.config.Role;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

    @Entity
    @Getter
    @Setter
    public class SiteUser {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id; //기본키

        @Column(unique = true, nullable = false, updatable = false)
        private String username; //아이디

        private String name;//이름

        @Column(nullable = false)
        private String password;

        private String phone;

        @Column(nullable = false)
        private String birth;

        @Enumerated(EnumType.STRING)
        private Role role;
    }
