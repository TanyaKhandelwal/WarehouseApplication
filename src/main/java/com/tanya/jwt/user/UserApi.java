package com.tanya.jwt.user;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/register")
public class UserApi{
@Autowired private UserRepository userRepo;
	
	@PostMapping()
	public ResponseEntity<User> create(@RequestBody @Valid User user) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		User savedUser = userRepo.save(user);
		
		
		String rawPassword = user.getPassword();
		String password = passwordEncoder.encode(rawPassword);
		User newUser = new User(user.getEmail(), password); 
		User savedUser = userRepo.save(newUser);
		
		URI userURI = URI.create("/register/" + savedUser.getId());
		return ResponseEntity.created(userURI).body(savedUser);
		
	}

	
	
	
	
	
//@RequestMapping(value = "/register", method=RequestMethod.POST)
//	@ResponseBody
//	public String create(@RequestParam(name = "email") String email, @RequestParam(name="password") String password) { 
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	String encryptedPassword = passwordEncoder.encode(password);
//	User newUser = new User(email, encryptedPassword); 
//	User savedUser = userRepo.save(newUser);
//	return "User registered successfully.";
////	    return "User registered successfully. Email : " + savedUser.getEmail() + "Password : " + savedUser.getPassword();
//	}

}
