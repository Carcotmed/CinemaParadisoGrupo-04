package com.cinema.cinemaparadiso.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="messages")
@Getter
@Setter
public class Message extends BaseEntity{
	
	@Column(name = "issue")
	@NotNull
	private String issue;
	
	@Column(name = "body")
	@NotNull
	private String body;
	
	@Column(name = "date")
	@NotNull
	//@PastOrPresent
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private Date date;
	
//	@ManyToOne(optional=false)
//	@JoinColumn(name = "user_id")
//	private List<User> user;
}
