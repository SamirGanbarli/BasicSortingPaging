package com.company.BasicPagingSorting.controller;


import com.company.BasicPagingSorting.model.Book;
import com.company.BasicPagingSorting.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepo;

    ArrayList<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1,"AA","FFF","****"),
            new Book(2,"BB","CCC","****"),
            new Book(3,"CC","DDD","****"),
            new Book(4,"DD","BBB","****"),
            new Book(5,"FF","SSS","****"),
            new Book(6,"GG","SSS","****"),
            new Book(7,"JJ","SSS","****"),
            new Book(8,"LL","SSS","****")
    ));


    @GetMapping("/")
    public void addBooks(){
        bookRepo.saveAll(books);
    }

    // here we get the outputs in a sorted order according to the field (name,authName,Des)
    // that we include as parameter to the function
    @GetMapping("/sorted/{field}/{type}")
    public List<Book> getBooks(@PathVariable String field, @PathVariable String type){

        if(type.equals("asc")) {
            return bookRepo.findAll(Sort.by(Sort.Direction.ASC, field));
        }else {
            return bookRepo.findAll(Sort.by(Sort.Direction.DESC, field));
        }
    }

    @GetMapping("/page/{offset}/{size}")
    public Page<Book> getPaginatedData(@PathVariable String offset, @PathVariable String size){

        return bookRepo.findAll(PageRequest.of(Integer.parseInt(offset), Integer.parseInt(size)));

    }
}
