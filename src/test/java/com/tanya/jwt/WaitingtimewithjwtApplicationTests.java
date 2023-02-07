package com.tanya.jwt;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.tanya.jwt.user.User;
import com.tanya.jwt.user.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class WaitingtimewithjwtApplicationTests {

	@Autowired private UserRepository repo;
	
	@Test
	public void testCreateUser() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "Abc123";
		String password = passwordEncoder.encode(rawPassword);
		
		User newUser = new User("abc@gmail.com", password);
		User savedUser = repo.save(newUser);
		
//		assertThat(savedUser).isNotNull();
//		assertThat(savedUser.getId()).isGreaterThan(0);
	}
}
