package com.dac.service;

import java.util.List;

import com.dac.bean.Book;

public interface BookService {

	List<Book> findAll();

	int addBook(Book book);

	Book findById(int bookid);

}
