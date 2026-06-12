package com.example.sunset.controller;


import com.example.sunset.dto.PostingDTO;
import com.example.sunset.entity.Posting;
import com.example.sunset.entity.SiteUser;
import com.example.sunset.service.PostingService;
import com.example.sunset.service.SiteUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostingController {
    private final PostingService postingService;
    private final SiteUserService siteUserService;

    @GetMapping("/posting/list")
    public String list(Model model)
    {
        List<Posting> posting = postingService.list();
        model.addAttribute("posting", posting);
         return "posting/list";
    }

    @GetMapping("/posting/view/{id}")
    public String view (
        Model model,
        @PathVariable("id") Long id)
//    ,CommentDTO. commentDTO
    {
        Posting posting = postingService.view(id);

        model.addAttribute("posting", posting);
        return "posting/view";
    }
    @GetMapping("/posting/chuga")
    public String chuga(){
        return "posting/chuga";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/posting/chugaProc")
    public String chugaProc(
            @Valid PostingDTO postingDTO,
                    BindingResult bindingResult,
                    Principal principal
    )
    {
        if(bindingResult.hasErrors())
        {return "posting/list";}

//        Posting posting = postingService.view(PostingDTO);
        SiteUser siteUser = siteUserService.getUser(principal.getName());
        this.postingService.chugaProc(postingDTO, siteUser);
        return "redirect:/posting/list";
    }

}
