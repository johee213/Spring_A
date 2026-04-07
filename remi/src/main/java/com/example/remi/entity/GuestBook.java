package com.example.remi.entity;


import com.example.remi.dto.GuestBookDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class GuestBook extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
    private Long id;
    private String name;
    private String email;
    private String passwd;
    private String content;

    //우리는 DTO 받아서 ENtity 로 만들어야해서 GuestBook  씀
    //서비스에서 처리하는곳에서
    //객체생성안하고 사용하려고 static 씀
    public static GuestBook createEntity (GuestBookDTO guestBookDTO) {

        GuestBook guestBook = new GuestBook();
        guestBook.setId(guestBookDTO.getId());
        guestBook.setName(guestBookDTO.getName());
        guestBook.setEmail(guestBookDTO.getEmail());
        guestBook.setPasswd(guestBookDTO.getPasswd());
        guestBook.setContent(guestBookDTO.getContent());
        return guestBook;


    }



}
