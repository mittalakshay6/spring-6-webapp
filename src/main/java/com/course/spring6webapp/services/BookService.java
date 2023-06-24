package com.course.spring6webapp.services;

import com.course.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
