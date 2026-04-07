package com.example.remi.controller;


import com.example.remi.dto.PhoneBookDTO;
import com.example.remi.entity.PhoneBook;
import com.example.remi.service.PhoneBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PhoneBookController {

    private final PhoneBookService phoneBookService;

    @GetMapping("/phoneBook/list") //이주소로 들어오면 이 메소드로 처리해
    public String list(
            Model model
    ){
        List<PhoneBook> list = phoneBookService.list();
        model.addAttribute("list", list);
        return "phoneBook/list"; //html 로 보내
    }

    @GetMapping("/phoneBook/view/{id}") //이주소로 들어오면 이 메소드로 처리해
    public String view(
            Model model,
            @PathVariable("id") Long id
    ){
        PhoneBook phoneBook = phoneBookService.view(id);
        //모델이 담기
        model.addAttribute("phoneBook", phoneBook);
        return "phoneBook/view";
    }

    @GetMapping("/phoneBook/chuga") //이주소로 들어오면 이 메소드로 처리해
    public String chuga(
            Model model
    ){
        return "phoneBook/chuga";
    }

    @GetMapping("/phoneBook/sujung/{id}") //이주소로 들어오면 이 메소드로 처리해
    public String sujung(
            Model model,
            @PathVariable("id") Long id
    ){
        PhoneBook phoneBook = phoneBookService.view(id);
        model.addAttribute("phoneBook", phoneBook);
        return "phoneBook/sujung";
    }

    @GetMapping("/phoneBook/sakje/{id}") //이주소로 들어오면 이 메소드로 처리해
    public String sakje(
            Model model,
            @PathVariable("id") Long id
    ){
        PhoneBook phoneBook = phoneBookService.view(id);
        model.addAttribute("phoneBook", phoneBook);
        return "phoneBook/sakje";
    }

    @PostMapping("/phoneBook/chugaProc")
    public  String chugaProc(
            PhoneBookDTO phoneBookDTO //
    ){
        phoneBookService.chugaProc(phoneBookDTO);
        return  "redirect:/phoneBook/list";
    }

    @PostMapping("/phoneBook/sujungProc")
    public  String sujungProc(
            PhoneBookDTO phoneBookDTO
    ){
        phoneBookService.sujungProc(phoneBookDTO);
        return  "redirect:/phoneBook/view/" + phoneBookDTO.getId();
    }

    @PostMapping("/phoneBook/sakjeProc")
    public  String sakjeProc(
            PhoneBookDTO phoneBookDTO
    ){
        phoneBookService.sakjeProc(phoneBookDTO);
        return  "redirect:/phoneBook/list";
    }

}



