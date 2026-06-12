package com.example.sunset.dto;


import com.example.sunset.config.Role;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
public class SiteUserDTO {


    private Long Id;
    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name; //이름

    @NotEmpty(message = "ID는 필수항목입니다.")
    private String username; //아이디

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password;

    private String phone;

    private Role role;




}
