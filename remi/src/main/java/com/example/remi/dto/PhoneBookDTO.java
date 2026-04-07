package com.example.remi.dto;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class PhoneBookDTO {

    private long id;
    private String name;
    private String phone;
    private String addresss;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String createrBy;
    private String modifiedBy;
}
