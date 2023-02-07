package com.tanya.jwt.time;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/time")
public class TimeApi implements TimeService{

	@Autowired private TimeRepository repo;
	
	@PostMapping
	public ResponseEntity<Time> create(@RequestBody @Valid Time time) {
		Time savedTime = repo.save(time);
		URI timeURI = URI.create("/time/" + savedTime.getId());
		return ResponseEntity.created(timeURI).body(savedTime);
	}
	
	@GetMapping
	public List<Time> list() {
		return repo.findAll();
	}
	
	@Override
	@GetMapping("last")
	public Time getLastAddedEntry() {
		// TODO Auto-generated method stub
		return repo.findTopByOrderByUpdatedOnDesc();
	}

	@Override
	@GetMapping("/{userid}")
	public List<Time> getEntryByUser(@PathVariable("userid") String userid) {
		// TODO Auto-generated method stub
		return repo.findByUserid(userid);
		
	}
	
	
//	@PostMapping
//	public ResponseEntity<Time> create(@RequestParam(name = "userId") String userId, @RequestParam(name="waitTime") int waitTime) {
//		Time time = new Time();
//		time.setUserId(userId);
//		time.setWaitTime(waitTime);
//		Time savedTime = repo.save(time);
//		URI timeURI = URI.create("/time/" + savedTime.getId());
//		return ResponseEntity.created(timeURI).body(savedTime);
//	}
	
	
	
}