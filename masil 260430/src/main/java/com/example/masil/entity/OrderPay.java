package com.example.masil.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class OrderPay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //기본키


    private String category; //카테고리


    private String price; //결제금액

    private LocalDateTime payday; // 결제날짜

    private String payType;//결제수단 (ex 카드 )

    @ManyToOne(cascade = CascadeType.REMOVE) // 또는 CascadeType.PERSIST
    @JoinColumn(name = "user_id")
    private SiteUser siteUser;
    private Long siteUserId;




}
