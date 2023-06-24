package com.course.spring6webapp.services;

import com.course.spring6webapp.domain.Author;
import org.springframework.stereotype.Service;

public interface AuthorService {
    Iterable<Author> findAll();
}
