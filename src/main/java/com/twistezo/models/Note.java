package com.twistezo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author twistezo
 *
 */

@Entity
@Table(name = "NOTES")
public class Note {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * MANY "Note" can belong to ONE "User.author"
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTHOR_ID")
	private User author;
	
	@Column(name = "TITLE", length = 50)
	private String title;
	
	@Column(name = "BODY", length = 500)
	private String body;
	
	@Column(name = "DATE")
	private Date date = new Date();
	
	@Column(name = "IS_DONE")
	private boolean isDone;

	public Note(){
		super();
	}
	
	public Note(Long id, User author, String title, String body, boolean isDone) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.body = body;
		this.isDone = isDone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	
}
