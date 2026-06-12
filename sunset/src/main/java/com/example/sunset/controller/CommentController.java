package com.example.sunset.controller;


import com.example.sunset.dto.CommentDTO;
import com.example.sunset.entity.Comment;
import com.example.sunset.entity.Posting;
import com.example.sunset.entity.SiteUser;
import com.example.sunset.service.CommentService;
import com.example.sunset.service.PostingService;
import com.example.sunset.service.SiteUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class CommentController {

    private final CommentService commentService;
    private final PostingService postingService;
    private final SiteUserService siteUserService;

//    @GetMapping("/comment/list")
//    public List<Comment> list(Model model, @PathVariable)
//    {
//        List<Commnet> list = commentService.list();
//        model.addAttribute("list",list);
//    }

//    @GetMapping("/commnet/view/{id}")
//    public String view(Model model,@PathVariable("id") Long id)
//    {
//      Comment comment = commentService.view(comm);
//      model.addAttribute("comment", comment);
//      return "comment/view/{id}";
//    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/comment/chugaProc")
    public String chugaProc(
            Model model,
            @Valid CommentDTO commentDTO,
            BindingResult bindingResult,
            Principal principal)
    {

        Posting posting = postingService.view(commentDTO.getPostingId());
        SiteUser siteUser = siteUserService.getUser(principal.getName());

        if(bindingResult.hasErrors())
        {
            model.addAttribute("posting", posting);
        return "redirect:/posting/view/ + commentDTO.getPostingId()";
        }

        commentService.chugaProc(commentDTO, siteUser);
        return "comment/list";
    }
}
