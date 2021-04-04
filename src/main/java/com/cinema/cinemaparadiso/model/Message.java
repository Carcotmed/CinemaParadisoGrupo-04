package com.cinema.cinemaparadiso.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	private Date messageDate;

	@OneToOne
	@JoinColumn(name = "emisor_id")
	private User emisor;

	@OneToOne
	@JoinColumn(name = "receptor_id")
	private User receptor;

	public Message(String issue, String body, Date messageDate, User emisor, User receptor) {
		super();
		this.issue = issue;
		this.body = body;
		this.messageDate = messageDate;
		this.emisor = emisor;
		this.receptor = receptor;
	}

	public Message() {
		super();
	}
	
	
}
