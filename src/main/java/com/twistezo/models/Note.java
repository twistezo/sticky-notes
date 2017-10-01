package com.twistezo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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

	@NotNull
	@Size(min = 2, max = 50)
	@Column(name = "TITLE", length = 50)
	private String title;

	@NotNull
	@Size(min = 2, max = 500)
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

	public Note() {
		super();
	}

	public Note(Long id, User author, String title, String body, boolean isDone) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.body = body;
		this.isDone = isDone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Note note = (Note) o;

		if (id != null ? !id.equals(note.id) : note.id != null)
			return false;
		return author != null ? author.equals(note.author) : note.author == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (author != null ? author.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Note{" + "id=" + id + ", author=" + author + ", title='" + title + '\'' + ", body='" + body + '\''
				+ ", date=" + date + ", isDone=" + isDone + ", noteChecked=" + noteChecked + '}';
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
