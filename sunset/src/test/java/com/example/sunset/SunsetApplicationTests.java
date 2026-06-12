package com.example.sunset;

import com.example.sunset.config.Role;
import com.example.sunset.entity.SiteUser;
import com.example.sunset.repository.SiteUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SunsetApplicationTests {

	@Autowired
	private SiteUserRepository siteUserRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void admin(){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode("1234");

		SiteUser siteUser = new SiteUser();

		siteUser.setUsername("admin666");
		siteUser.setName("관리자");
		siteUser.setPassword(password);
		siteUser.setPhone("010-0000-0000");
		siteUser.setRole(Role.ADMIN);
		siteUserRepository.saveAndFlush(siteUser);
	}

}
