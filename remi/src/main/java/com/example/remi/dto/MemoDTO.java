package com.example.remi.dto;

import lombok.*;


import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter // 게터세터만 기억하기
@Setter // 게터세터만 기억하기
public class MemoDTO {

    private Long id;
    private String writer;
    private String content;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String createrBy;
    private String modifiedBy;
}
