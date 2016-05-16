package org.gotprint.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long noteId;

	@NotNull
	@Size(max = 50)
	private String title;

	@NotNull
	@Size(max = 1000)
	private String noteText;

	private String createdTime;


	private String lastUpdatedTime;

	@ManyToOne
	@JoinColumn(name = "id")
	private User user;

	private String emailId;

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(String title, String noteText, String createdTime,
			String lastUpdatedTime, String emailId) {
		super();
		this.title = title;
		this.noteText = noteText;
		this.createdTime = createdTime;
		this.lastUpdatedTime = lastUpdatedTime;
		this.emailId = emailId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNoteText() {
		return noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getNoteId() {
		return noteId;
	}

	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
