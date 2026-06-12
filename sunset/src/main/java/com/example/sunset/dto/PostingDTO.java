package com.example.sunset.dto;


import com.example.sunset.entity.SiteUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PostingDTO {


    private Long id;

    @NotEmpty(message = "제목은 필수항목입니다.")
    private String subject;


    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;

    private String createdDate;



    private SiteUser siteUser;
}
