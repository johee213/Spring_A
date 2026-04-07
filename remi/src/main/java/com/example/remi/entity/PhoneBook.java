package com.example.remi.entity;

import com.example.remi.dto.MemoDTO;
import com.example.remi.dto.PhoneBookDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter //값을 읽어온다?
@Setter

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneBook extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    private String addresss;

    // DTO받아서 Entity 로 만들어라
    // service에 chugaProc 사용하려고 만듬
    public static PhoneBook createEntity(PhoneBookDTO phoneBookDTO) {
        //DTO 자료를 Entity에 담는 과정

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setId(phoneBookDTO.getId());
        //phoneBookDTO.getName() dto에있는 name 읽어와서 phoneBook.setName 저장해
        phoneBook.setName(phoneBookDTO.getName());
        phoneBook.setPhone(phoneBookDTO.getPhone());
        phoneBook.setAddresss(phoneBookDTO.getAddresss());
        //
        phoneBook.setCreatedBy(phoneBook.getCreatedBy());
        phoneBook.setModifiedDate(phoneBook.getModifiedDate());

        return phoneBook;
    }
}




