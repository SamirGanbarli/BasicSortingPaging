package com.company.BasicPagingSorting.repository;

import com.company.BasicPagingSorting.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
