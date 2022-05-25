package domainMany2Many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Bok {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bokId;

	@ManyToMany(mappedBy = "bok",targetEntity = Author.class)
	private List<Author> authors = new ArrayList<>();

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	private String name;
	private String isbn;

	@Override
	public String toString() {
		return "Bok [bokId=" + bokId + ", name=" + name + ", isbn=" + isbn + "]";
	}

}
