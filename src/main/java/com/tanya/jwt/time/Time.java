package com.tanya.jwt.time;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "time")
public class Time {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@UpdateTimestamp
    @Column(name = "updatedate")
    private Date updatedOn;
	
	@Column(nullable = false)
	private String userid;
	
	private int waittime;
	
	

	public Time() {
	}
	
	public Time(String userid, int waittime) {
		this.userid = userid;
		this.waittime = waittime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userid;
	}

	public void setUserId(String userid) {
		this.userid = userid;
	}

	public int getWaitTime() {
		return waittime;
	}

	public void setWaitTime(int waittime) {
		this.waittime = waittime;
	}
	
	public Date getUpdatedOn() {
        return updatedOn;
    }
 
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

}