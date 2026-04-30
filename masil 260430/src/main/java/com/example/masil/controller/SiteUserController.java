package com.example.masil.controller;


import com.example.masil.dto.SiteUserDTO;
import com.example.masil.entity.SiteUser;
import com.example.masil.service.SiteUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class SiteUserController {
    private final SiteUserService siteUserService;

    @GetMapping("/siteUser/list")
    public String list(
            Model model,
            @RequestParam(value="page", defaultValue = "0") int page
    ){
        Page<SiteUser> paging = siteUserService.list(page);
        model.addAttribute("paging", paging);
        return "siteUser/list";
    }

    @GetMapping("/siteUser/view/{id}")
    public String view(
            Model model,
            @PathVariable("id") Long id,
            SiteUserDTO siteUserDTO
    ){
        SiteUser siteUser = siteUserService.view(id);
        model.addAttribute("user", siteUser);
        return "siteUser/view";
    }

    @GetMapping("/siteUser/chuga")
    public String chuga(
            Model model,
            SiteUserDTO siteUserDTO
    ){
        return "siteUser/chuga";
    }

    public String sujung(
            Model model,
            @PathVariable("id") Long id
    ){
        SiteUser siteUser = siteUserService.view(id);
        model.addAttribute("siteUser", siteUser);
        return "siteUser/sujung";
    }

    @GetMapping("/siteUser/sakje/{id}")
    public String sakje(
            Model model,
            @PathVariable("id") Long id
    ){
        SiteUser siteUser = siteUserService.view(id);
        model.addAttribute("siteUser", siteUser);
        return "siteUser/sakje";
    }

    @PostMapping("/siteUser/chugaProc")
    public String chugaProc(
            @Valid SiteUserDTO siteUserDTO,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "siteUser/chuga";
        }
        if (!siteUserDTO.getPassword().equals(siteUserDTO.getPasswordChk())) {
            bindingResult.rejectValue("passwordChk", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "siteUser/chuga";
        }

        try{
            siteUserService.chugaProc(siteUserDTO);
        } catch(DataIntegrityViolationException e){
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "siteUser/chuga";
        } catch (Exception e) {
            bindingResult.reject("chugaFailed", e.getMessage());
            return "siteUser/chuga";
            }
            return "redirect:/";
        }

        @PostMapping("/siteUser/sujungProc")
        public String sujungProc(
                SiteUserDTO siteUserDTO
        ){
            SiteUser siteUser = siteUserService.view(siteUserDTO.getId());

            if(siteUser == null){
                return "redirect:/";
            }
            if (!siteUserDTO.getPassword().equals(siteUser.getPassword()))
            {
                return "redirect:/siteUser/list";
            }
            siteUserService.sujungProc(siteUserDTO);
            return "redirect:/siteUser/view/" + siteUserDTO.getId();
        }

        @PostMapping("/siteUser/sakjeProc")
        public String sakjeProc(
                SiteUserDTO siteUserDTO
        ){
            siteUserService.sakjeProc(siteUserDTO);
            return "redirect:/siteUser/list";
        }

        @GetMapping("siteUser/login")
        public String login(){
         return "siteUser/login";
        }
}


