package com.cinema.cinemaparadiso.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name = "messagedate")
	@NotNull
	//@PastOrPresent
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private Date messagedate;
	
	@NotNull
	@Column(name = "emisor_id")
	private Integer emisor_id;
	
	@NotNull
	@Column(name = "recepetor_id")
	private Integer recepetor_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
}
