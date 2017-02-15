package com.twistezo.models;

import javax.persistence.*;
import java.util.Date;

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

    /**
     * @Transient is used for non connecting this field with DB
     */
    @Transient
    private boolean noteChecked = false;

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

    public boolean isNoteChecked() {
        return noteChecked;
    }

    public void setNoteChecked(boolean noteChecked) {
        this.noteChecked = noteChecked;
    }
}
