package com.twistezo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author twistezo
 *
 */

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
    @Size(min=2, max=30)
	@Column(name = "USERNAME", length = 50)
	private String username;

	@NotNull
    @Size(min=2, max=30)
	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;

    @NotNull
    @Size(min=2, max=30)
	@Column(name = "LAST_NAME", length = 50)
	private String lastName;

    @NotNull
    @Size(min=2, max=30)
	@Column(name = "PASSWORD", length = 60)
	private String password;

    @Size(min=2, max=30)
	@Column(name = "ROLE", length = 50)
	private String role;
	
	/**
	 * ONE User.author can have MANY <Note>notes
	 */
	@OneToMany(mappedBy = "author")
	private Set<Note> notes = new HashSet<>();

    /**
     * @Transient is used for non connecting this field with DB
     */
    @Transient
	private boolean userChecked = false;

	public User() {
		super();
	}
	
	public User(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isUserChecked() {
		return userChecked;
	}

	public void setUserChecked(boolean userChecked) {
		this.userChecked = userChecked;
	}

}
