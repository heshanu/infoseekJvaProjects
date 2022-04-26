package com.example.demo;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Post;
import com.example.demo.entity.Tag;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.TagRepository;

@SpringBootApplication
public class SpringJpaMany2ManyApplication implements CommandLineRunner {

	@Autowired
	private PostRepository postrepository;

	@Autowired
	private TagRepository tagrepository;

	public static void main(String[] args) {

		SpringApplication.run(SpringJpaMany2ManyApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Post post = new Post("one to many mapping using JPA and hibernate",
				"one to many mapping using JPA and hibernate");

		Comment comment1 = new Comment("Very useful");
		Comment comment2 = new Comment("informative");
		Comment comment3 = new Comment("Great post");

		post.getComments().add(comment1);
		post.getComments().add(comment2);
		post.getComments().add(comment3);

		this.postrepository.save(post);*/
	}

}
