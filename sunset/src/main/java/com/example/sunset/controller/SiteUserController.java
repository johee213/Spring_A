package com.example.sunset.controller;
import com.example.sunset.dto.SiteUserDTO;
import com.example.sunset.entity.SiteUser;
import com.example.sunset.service.SiteUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SiteUserController {
    private final SiteUserService siteUserService;

    @GetMapping("/siteUser/list")
    public String list(
            Model model
    ){
        List<SiteUser> siteUser = siteUserService.list();
        model.addAttribute("siteUser", siteUser);
        return "siteUser/list";
    }

    @GetMapping("/siteUser/view/{id}")
    public String view(
            Model model,
            @PathVariable("id")Long id)
    {
        SiteUser siteUser = siteUserService.view(id);
        model.addAttribute("siteUser", siteUser);
        return "siteUser/view" + id;
    }

    @GetMapping("/siteUser/chuga")
    public String chuga(Model model)
    {return "siteUser/chuga";}

    @GetMapping("/siteUser/sujung/{id}")
    public String sujung(
            Model model,
            @PathVariable("id")Long id
    ){
        SiteUser siteUser = siteUserService.view(id);
        model.addAttribute("siteUser", siteUser);
        return "siteUser/sujung";
    }

    @GetMapping("/siteUser/sakje/{id}")
    public String sakje(
            Model model,
            @PathVariable("id")Long id
    ){
        SiteUser siteUser = siteUserService.view(id);
        model.addAttribute("siteUser", siteUser);
        return "siteUser/sakje";
    }

    @PostMapping("/siteUser/chugaProc")
    public String chugaProc(
            @Valid SiteUserDTO siteUserDTO,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors())
        {return "siteUser/chuga";}

        try {
            siteUserService.chugaProc(siteUserDTO);
        } catch(DataIntegrityViolationException e) {
            //e.printStackTrace();
            bindingResult.reject("chugaFailed", "이미 등록된 사용자입니다.");
            return "siteUser/chuga";
        } catch(Exception e) {
            //e.printStackTrace();
            bindingResult.reject("chugaFailed", e.getMessage());
            return "siteUser/chuga";
        }
        return "redirect:/siteUser/chuga";}

    @PostMapping("/siteUser/sujungProc/{id}")
    public String sujungProc(
            @PathVariable("id") Long id,
        @Valid SiteUserDTO siteUserDTO,
        BindingResult bindingResult,
        Principal principal
    ){
        SiteUser siteUser = siteUserService.view(id);
//        if(bindingResult.hasErrors())
//        {return "siteUser/sujung";}


        return "redirect:/siteUser/view";
    }


    @GetMapping("/siteUser/login")
    public String loginForm() {
        return "siteUser/login";
    }



//    @PostMapping("/login")
//    public String login(String username, String password, HttpSession session) {
//        // 1. 검증 로직...
//        // 2. 성공 시 세션 저장
//        session.setAttribute("user", username);
//
//        // 중요: 로그인 끝났으니 이제 게시판 리스트로 '보내버림(Redirect)'
//        return "redirect:/posting/list";
//    }




}
