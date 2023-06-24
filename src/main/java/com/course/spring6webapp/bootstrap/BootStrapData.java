package com.course.spring6webapp.bootstrap;

import com.course.spring6webapp.domain.Author;
import com.course.spring6webapp.domain.Book;
import com.course.spring6webapp.domain.Publisher;
import com.course.spring6webapp.repositories.AuthorRepository;
import com.course.spring6webapp.repositories.BookRepository;
import com.course.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("Akshay");
        author.setLastName("Mittal");

        Book book = new Book();
        book.setTitle("Woh Woh Main aur Mera Dost");

        Author author2 = new Author();
        author2.setFirstName("Another");
        author2.setLastName("Author");

        Book book2 = new Book();
        book2.setTitle("Yet to start");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Mittal Publications");

        Author authorSaved = authorRepository.save(author);
        Book bookSaved = bookRepository.save(book);
        Author author2Saved = authorRepository.save(author2);
        Book book2Saved = bookRepository.save(book2);
        Publisher publisherSaved = publisherRepository.save(publisher);

        authorSaved.getBooks().add(bookSaved);
        author2Saved.getBooks().add(book2Saved);
        bookSaved.getAuthors().add(authorSaved);
        book2Saved.getAuthors().add(author2Saved);
        bookSaved.setPublisher(publisherSaved);
        book2Saved.setPublisher(publisherSaved);

        authorRepository.save(authorSaved);
        authorRepository.save(author2Saved);
        bookRepository.save(bookSaved);
        bookRepository.save(book2Saved);

        System.out.println("In BootStrapData");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
