package com.example.masil.dto;

import com.example.masil.config.Role;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SiteUserDTO {

    private Long Id; //기본키
    private String username; //아이디
    private String name;//이름
    private String password;
    private String passwordChk;
    private String phone;
    private String birth;


    private Role role;
}
