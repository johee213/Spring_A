package com.example.sunset.repository;

import com.example.sunset.entity.Posting;
import com.example.sunset.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SiteUserRepository extends JpaRepository <SiteUser, Long> {

    Optional<SiteUser> findByusername(String username);

}
