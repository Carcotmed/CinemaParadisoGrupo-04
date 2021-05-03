package com.cinema.cinemaparadiso.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message="No puedes dejarlo vacío.")
	private String issue;
	
	@Column(name = "body")
    @NotBlank(message="No puedes dejarlo vacío.")
	@Size(min=10,max=900,message="Use un cuerpo de mensaje que contenga entre 10 y 900 carácteres")
	private String body;
	
	@Column(name = "messagedate")
	//@PastOrPresent
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private Date messageDate;
	
	@Column(columnDefinition = "bool default false")
	private boolean seen;

	@OneToOne
	@JoinColumn(name = "emisor_id")
	private User emisor;

	@OneToOne
	@JoinColumn(name = "receptor_id")
	private User receptor;
	
	@JoinColumn(name = "is_request")
	private Integer isRequest;
	
	@ManyToOne()
	@JoinColumn(name = "story_id")
	private Story story;

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

	public Message(
			@Size(min = 3, max = 30, message = "Es necesario que el asunto tenga entre 3 y 30 caracteres") @NotBlank(message = "No puedes dejarlo vacío.") String issue,
			@NotBlank(message = "No puedes dejarlo vacío.") @Size(min = 10, max = 900, message = "Use un cuerpo de mensaje que contenga entre 10 y 900 carácteres") String body,
			Date messageDate, boolean seen, User emisor, User receptor, Integer isRequest, Story story) {
		super();
		this.issue = issue;
		this.body = body;
		this.messageDate = messageDate;
		this.seen = seen;
		this.emisor = emisor;
		this.receptor = receptor;
		this.isRequest = isRequest;
		this.story = story;
	}
	
	public Message(
			@Size(min = 3, max = 30, message = "Es necesario que el asunto tenga entre 3 y 30 caracteres") @NotBlank(message = "No puedes dejarlo vacío.") String issue,
			@NotBlank(message = "No puedes dejarlo vacío.") @Size(min = 10, max = 900, message = "Use un cuerpo de mensaje que contenga entre 10 y 900 carácteres") String body,
			Date messageDate, boolean seen, User emisor, User receptor, Integer isRequest) {
		super();
		this.issue = issue;
		this.body = body;
		this.messageDate = messageDate;
		this.seen = seen;
		this.emisor = emisor;
		this.receptor = receptor;
		this.isRequest = isRequest;
	}
	
	
}
