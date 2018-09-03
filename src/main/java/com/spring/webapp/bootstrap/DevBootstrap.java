package com.spring.webapp.bootstrap;

import com.spring.webapp.model.Author;
import com.spring.webapp.model.Book;
import com.spring.webapp.model.Publisher;
import com.spring.webapp.repository.AuthorRepository;
import com.spring.webapp.repository.BookRepository;
import com.spring.webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}
	
	private void initData() {
		// Publisher
		Publisher harperCollins = new Publisher("Harper Collins", "123 Main St.", "Ste. 101", "New York", "NY", 12345);
		publisherRepository.save(harperCollins);
		
		Publisher time = new Publisher("Time Inc.", "987 Broad St.", "# A", "Los Angeles", "CA", 98543);
		publisherRepository.save(time);
		
		// Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		// Rod
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Dev without EJB", "4321", time);
		eric.getBooks().add(noEJB);
		ddd.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}
}
