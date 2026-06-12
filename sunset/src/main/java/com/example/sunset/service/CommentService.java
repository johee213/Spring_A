package com.example.sunset.service;


import com.example.sunset.dto.CommentDTO;
import com.example.sunset.entity.Comment;
import com.example.sunset.entity.Posting;
import com.example.sunset.entity.SiteUser;
import com.example.sunset.repository.CommentRepository;
import com.example.sunset.repository.PostingRepository;
import com.example.sunset.repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final SiteUserRepository siteUserRepository;
    private final PostingService postingService;
    private final PostingRepository postingRepository;

    public Comment view(Long id) {
        Optional<Comment> op = commentRepository.findById(id);

        Comment comment = null;
        if (op.isPresent()) {
            comment = op.get();
        }

        return comment;
    }

    public void chugaProc (CommentDTO commentDTO, SiteUser siteUser)
    {
        Posting posting = postingService.view(commentDTO. getPostingId());
        Comment comment = createEntity(commentDTO, siteUser);
        commentRepository.save(comment);
    }


    public void sujungProc (CommentDTO commentDTO, SiteUser siteUser)
    {
        Posting posting = postingService.view(commentDTO. getPostingId());
        Comment comment = createEntity(commentDTO, siteUser);
        commentRepository.save(comment);
    }

    public void sakjeProc (CommentDTO commentDTO, SiteUser siteUser)
    {
        Posting posting = postingService.view(commentDTO. getPostingId());
        Comment comment = createEntity(commentDTO, siteUser);
        commentRepository.delete(comment);
    }


    public Comment createEntity(
            CommentDTO commentDTO, SiteUser siteUser
    ){
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setCreatedDate(LocalDate.now().toString());
        comment.setSiteUser(siteUser);

        Posting posting = postingRepository.findById(commentDTO.getPostingId())
                .orElseThrow(() -> new RuntimeException("게시글 없음"));

        comment.setPosting(posting);
        return comment;
    }


}



