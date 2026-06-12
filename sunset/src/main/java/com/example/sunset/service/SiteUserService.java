package com.example.sunset.service;


import com.example.sunset.config.Role;
import com.example.sunset.dto.SiteUserDTO;
import com.example.sunset.entity.Posting;
import com.example.sunset.entity.SiteUser;
import com.example.sunset.exception.DataNotFoundException;
import com.example.sunset.repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SiteUserService implements UserDetailsService {

    private  final SiteUserRepository siteUserRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser createEntity(SiteUserDTO siteUserDTO)
    {
        SiteUser siteUser = new SiteUser();
        siteUser.setId(siteUserDTO.getId());
        siteUser.setName(siteUserDTO.getName());
        siteUser.setUsername(siteUserDTO.getUsername());
        siteUser.setPassword(siteUserDTO.getPassword());
        siteUser.setPhone(siteUserDTO.getPhone());
        siteUser.setRole(Role.USER);
        return siteUser;
    }

    public List<SiteUser> list(){
        return siteUserRepository.findAll();
    }

    public SiteUser view(Long id)
    {
        Optional<SiteUser> og = siteUserRepository.findById(id);
        SiteUser siteUser = null;
        if(og.isPresent())
        {
            siteUser = og.get();
        }

        return siteUser;
    }

    public void chugaProc(SiteUserDTO siteUserDTO)
    {
        SiteUser siteUser = createEntity(siteUserDTO);
        siteUser.setPassword(passwordEncoder.encode(siteUserDTO.getPassword()));
        siteUserRepository.save(siteUser);
    }

    public void sujungProc(SiteUserDTO siteUserDTO)
    {
        SiteUser siteUser = createEntity(siteUserDTO);
        siteUserRepository.save(siteUser);
    }

    public void sakjeProc(SiteUserDTO siteUserDTO)
    {
        SiteUser siteUser = createEntity(siteUserDTO);
        siteUserRepository.delete(siteUser);
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = siteUserRepository.findByusername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteUser not found");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SiteUser siteUser = siteUserRepository.findByusername(username)
                .orElseThrow(() -> new UsernameNotFoundException("유저없음"));

        return User.builder()
                .username(siteUser.getUsername())
                .password(siteUser.getPassword())
                .roles(siteUser.getRole().name())  // DB role 적용
                .build();
    }

}



