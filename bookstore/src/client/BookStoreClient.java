package client;

import java.util.ArrayList;
import java.util.List;

import service.BookStoreService;


import domain.Book;
import domain.Chapter;
import domain.Publisher;

public class BookStoreClient {
	public static void main(String[] args) {
		BookStoreService bookStoreService = new BookStoreService();

		//persisting object graph
		Publisher publisher = new Publisher("MAN1", "Manning Publications Co.");

		Book book = new Book("9781617290455", "Java Persistence with Hibernate1, Second Edition1", publisher);

		List<Chapter> chapters = new ArrayList<Chapter>();
		Chapter chapter1 = new Chapter("Introducing JPA and Hibernate", 1);
		//chapters.add(chapter1);
		Chapter chapter2 = new Chapter("Domain Models and Metadata", 2);
		//chapters.add(chapter2);
		Chapter chapter3 = new Chapter("Domain Models and Metadata", 3);
		chapters.add(chapter3);
		book.setChapters(chapters);

		bookStoreService.persistObjectGraph(book);

		//retrieving object graph
		/*
		Book book = bookStoreService.retrieveObjectGraph("9781617290459");
		System.out.println(book);
		*/

	}
}





