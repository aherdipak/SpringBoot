package com.dac.app.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="people_master")

//Normally when we update record application is fire bellow query 
// "update people_master set added_date=?, email=?, first_name=?, last_name=? where id=?"
// which may degreed the performance of application
// whatever field we are updating those filed should be updated.
// to avoid this we have to use bellow annotation which will fire bellow query on DB
// "update people_master set email=? where id=?"
@DynamicUpdate
public class People {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="FIRST_NAME",length = 60,nullable = false)
	private String firstName;
	
	@Column(name="LAST_NAME",length = 60,nullable = false)
	private String lastName;
	
	@Column(name="EMAIL",unique = true)
	private String email;
	
	@Column(name="ADDED_DATE")
	private Date addedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public People( String firstName, String lastName, String email, Date addedDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.addedDate = addedDate;
	}

	public People() {
		
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", addedDate=" + addedDate + "]";
	}
	
	
	

}
