package com.example.masil.service;

import com.example.masil.dto.SiteUserDTO;
import com.example.masil.entity.SiteUser;
import com.example.masil.exception.DataNotFoundException;
import com.example.masil.repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;

    public Page<SiteUser> list(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return siteUserRepository.findAll(pageable);
    }

    public SiteUser view(Long id) {
        Optional<SiteUser> op = siteUserRepository.findById(id);
        SiteUser siteUser = null;
        if (op.isPresent()){
            siteUser = op.get();
        }
        return siteUser;
    }

    public void chugaProc(SiteUserDTO siteUserDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(siteUserDTO.getPassword());

        SiteUser siteUser = new SiteUser();
        siteUser.setId(siteUserDTO.getId());
        siteUser.setUsername(siteUserDTO.getUsername());
        siteUser.setName(siteUserDTO.getName());
        siteUser.setPassword(password);
        siteUser.setPhone(siteUserDTO.getPhone());
        siteUser.setBirth(siteUserDTO.getBirth());
        siteUserRepository.save(siteUser);
    }

    public void sujungProc (SiteUserDTO siteUserDTO) {
        SiteUser siteUser = new SiteUser();
        siteUser.setId(siteUserDTO.getId());
        siteUser.setUsername(siteUserDTO.getUsername());
        siteUser.setName(siteUserDTO.getName());
        siteUser.setPassword(siteUserDTO.getPassword());
        siteUser.setPhone(siteUserDTO.getPhone());
        siteUser.setBirth(siteUserDTO.getBirth());
        siteUserRepository.save(siteUser);
    }

    public void sakjeProc(SiteUserDTO siteUserDTO) {
        SiteUser siteUser = new SiteUser();
        siteUser.setId(siteUserDTO.getId());
        siteUser.setUsername(siteUserDTO.getUsername());
        siteUser.setName(siteUserDTO.getName());
        siteUser.setPassword(siteUserDTO.getPassword());
        siteUser.setPhone(siteUserDTO.getPhone());
        siteUser.setBirth(siteUserDTO.getBirth());
        siteUserRepository.delete(siteUser);
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> user = siteUserRepository.findByUsername(username);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new DataNotFoundException("user not found");
        }
    }

    public boolean isUsernameAvailable(String username) {
        // 1. DB에서 해당 아이디로 조회합니다.
        Optional<SiteUser> siteUser = siteUserRepository.findByUsername(username);

        // 2. 결과가 비어있어야(isEmpty) -> 중복이 아님 -> true(사용 가능) 반환
        // 결과가 존재하면(isPresent) -> 중복임 -> false(사용 불가) 반환
        return siteUser.isEmpty();
    }
}

