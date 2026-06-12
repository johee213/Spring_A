package com.example.sunset.dto;
import com.example.sunset.entity.Posting;
import com.example.sunset.entity.SiteUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommentDTO {


    private Long id;

    @NotEmpty(message = "답변은 필수항목입니다.")
    private String content;


    private String createdDate;


    private Long postingId;


    private Long siteUserId;


}
