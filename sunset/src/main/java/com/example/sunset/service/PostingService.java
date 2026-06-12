package com.example.sunset.service;

import com.example.sunset.dto.PostingDTO;
import com.example.sunset.entity.Posting;
import com.example.sunset.entity.SiteUser;
import com.example.sunset.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;

    public Posting createEntity(PostingDTO postingDTO, SiteUser siteUser){
        Posting posting = new Posting();
        posting.setId(postingDTO.getId());
        posting.setSubject(postingDTO.getSubject());
        posting.setContent(postingDTO.getContent());
        posting.setCreatedDate(LocalDate.now().toString());  // 자동 날짜
        posting.setSiteUser(siteUser);
        return posting;
    }

    public List<Posting> list() {
        return postingRepository.findAll();
    }

    public Posting view(Long id){
        Optional<Posting> og = postingRepository.findById(id);

        Posting posting = null;
        if(og.isPresent()){
            posting = og.get();
        }
        return posting;
    }
    public void chugaProc (PostingDTO postingDTO, SiteUser siteUser){
        Posting posting = createEntity(postingDTO, siteUser);
        postingRepository.save(posting);
    }

    public void sujungaProc (PostingDTO postingDTO, SiteUser siteUser){
        Posting posting = createEntity(postingDTO, siteUser);
        postingRepository.save(posting);
    }

    public void sakjeProc (PostingDTO postingDTO, SiteUser siteUser){
        Posting posting = createEntity(postingDTO, siteUser);
        postingRepository.delete(posting);
    }
}
