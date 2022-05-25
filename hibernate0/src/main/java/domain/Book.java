package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_tbl")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookId;
	private String isbn;
	private String name;

	@OneToOne
	@JoinColumn(name = "stdent_id")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public long getBookId() {
		return bookId;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", student=" + student + ", author=" + author + "]";
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	private String author;

}
