package com.spring.webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String isbn;
	private String publisher;
	
	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();
}
