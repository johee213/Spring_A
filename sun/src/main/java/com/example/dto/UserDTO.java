package com.example.dto;

import com.example.config.Role;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {

    private Long userId; //기본키
    private String userName; //이름
    private String password;
    private String passwordChk;
    private String phone;
    private String birth;


    private Role role;
}
