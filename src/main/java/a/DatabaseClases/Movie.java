package a.DatabaseClases;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	@Column
	private int yearOfProduction;
	
	@ManyToOne
	private Director director;
	
	@ManyToMany(cascade={CascadeType.ALL})
	@NotFound(action=NotFoundAction.IGNORE)
	private Collection<Type> types = new ArrayList<Type>();
	
	public Movie(){}
	public Movie(String name, int yearOfProduction, Director director) {
		
		this.name = name;
		this.yearOfProduction = yearOfProduction;
		this.director = director;
	
	}
	
	public int getYearOfProduction() {
		return yearOfProduction;
	}
	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
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

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

}
