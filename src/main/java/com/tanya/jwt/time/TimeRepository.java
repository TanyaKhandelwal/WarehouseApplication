package com.tanya.jwt.time;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {
	public Time findTopByOrderByUpdatedOnDesc();
	public List<Time> findByUserid(String userid);
}

