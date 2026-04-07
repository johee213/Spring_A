package com.example.remi.service;


import com.example.remi.Repository.PhoneBookRepository;
import com.example.remi.dto.MemoDTO;
import com.example.remi.dto.PhoneBookDTO;
import com.example.remi.entity.Memo;
import com.example.remi.entity.PhoneBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor //
@Service
public class PhoneBookService {

    private final PhoneBookRepository phoneBookRepository;

    //전체목록 몇개를 반환하는지 몰라서 List<>
    public List<PhoneBook> list(){
        return phoneBookRepository.findAll();

    }
    //한줄만 반환하면 되서 phoneBook으로 반환함
    public PhoneBook view(Long id) {
        // return phoneBookRepository.findById(id).orElse(null);
        Optional<PhoneBook> optionalPhoneBook = phoneBookRepository.findById(id);
        PhoneBook phoneBook = null;
        //isPresent 존재하면
        if(optionalPhoneBook.isPresent()) {
            phoneBook = optionalPhoneBook.get();
        }
        return phoneBook;
    }
    //DTO >> entity 로 바꾸고
    public void chugaProc(PhoneBookDTO phoneBookDTO) {
        PhoneBook phoneBook = PhoneBook.createEntity(phoneBookDTO);
        phoneBookRepository.save(phoneBook);

    }

    public void sujungProc(PhoneBookDTO phoneBookDTO){
        PhoneBook phoneBook = PhoneBook.createEntity(phoneBookDTO);
        phoneBookRepository.save(phoneBook);
    }

    public  void sakjeProc(PhoneBookDTO phoneBookDTO){
        PhoneBook phoneBook = PhoneBook.createEntity(phoneBookDTO);
        phoneBookRepository.delete(phoneBook);
    }

}




