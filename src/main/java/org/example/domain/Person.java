package org.example.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Osoby")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="imie")
	private String name;
	
	@Column(name="nazwisko")
	private String surname;
	@Column(name="pesel")
	private String nationalIdentificationNumber;
	
	@OneToMany(mappedBy="person")
	private Collection<Address> addresses = new ArrayList<Address>();
	@OneToOne
	private User user;
	
	
	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNationalIdentificationNumber() {
		return nationalIdentificationNumber;
	}

	public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
		this.nationalIdentificationNumber = nationalIdentificationNumber;
	}


	
}
