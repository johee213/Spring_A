package com.example.remi.service;


import com.example.remi.Repository.GuestBookRepository;
import com.example.remi.dto.GuestBookDTO;
import com.example.remi.entity.GuestBook;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GuestBookService {
    //리푀지트리 객체주입
    private final GuestBookRepository guestBookRepository;

    public List<GuestBook> list(){
        return guestBookRepository.findAll();
    }

    public GuestBook view(Long id){
        //값이 있을지 없을지 모르니까 optional 씀
       Optional<GuestBook> og = guestBookRepository.findById(id);
       //초기값으로 널을줘서 값이있으면 og를 guestbook으로 넣어
        //값이 없으면 null로 나옴
       GuestBook guestBook = null;
       if(og.isPresent()) {
           guestBook = og.get();
       }
       return guestBook;
    }

    //DTO 를 Entity 로 바꿔주는 작업해야함 >> 메소드만들어서 쓰짜 >> entity에서 스태틱써서 변경하여 사용
    public void chugaProc(GuestBookDTO guestBookDTO){
        //클래스이릠. 메소드 == GuestBook.createEntity (entity에만듬)
        GuestBook guestBook = GuestBook.createEntity(guestBookDTO);
        guestBookRepository.save(guestBook);

    }
    public void sujungProc(GuestBookDTO guestBookDTO){
        GuestBook guestBook = GuestBook.createEntity(guestBookDTO);
        guestBookRepository.save(guestBook);
    }

    public void sakjeProc(GuestBookDTO guestBookDTO){
        GuestBook guestBook = GuestBook.createEntity(guestBookDTO);
        guestBookRepository.delete(guestBook);
    }



}
