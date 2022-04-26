package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Movie {
	
	//for Hibernate 4.3.x Users
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	// for Hibernate 5.x Users
	// if you're using Hibernate 5.x, use GenerationType.IDENTITY id generator strategy explicitly
	// for more information on "GenerationType" have a look at https://www.udemy.com/hibernate-and-jpa-fundamentals/learn/v4/questions/937412
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	*/
	
	private String name;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
    @JoinTable(
            		name="movie_actor",
            		joinColumns={@JoinColumn(name="movie_id")},
            		inverseJoinColumns={@JoinColumn(name="actor_id")}
    	)	
	private Set<Actor> actors = new HashSet<Actor>();	
	
	public Movie() {}
	public Movie(String name) {
		this.name = name;
	}
	
	public Set<Actor> getActors() {
		return actors;
	}
	
}




