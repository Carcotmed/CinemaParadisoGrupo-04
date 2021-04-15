package com.cinema.cinemaparadiso.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="messages")
@Getter
@Setter
public class Message extends BaseEntity{
	
	@Column(name = "issue")
	@Size(min=3,max=30,message="Es necesario que el asunto tenga entre 3 y 30 caracteres")
	private String issue;
	
	@Column(name = "body")
	@NotEmpty(message="No puede dejar el cuerpo del mensaje vacío")
	@Size(min=10,max=900,message="Use un cuerpo de mensaje que contenga entre 10 y 900 carácteres")
	private String body;
	
	@Column(name = "messagedate")
	//@PastOrPresent
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private Date messageDate;

	@OneToOne
	@JoinColumn(name = "emisor_id")
	private User emisor;

	@OneToOne
	@JoinColumn(name = "receptor_id")
	private User receptor;
	
	@JoinColumn(name = "is_request")
	private Integer isRequest;

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
