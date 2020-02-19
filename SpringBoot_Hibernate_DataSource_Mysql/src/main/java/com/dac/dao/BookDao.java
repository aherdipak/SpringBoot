package com.dac.dao;

import java.util.List;

import com.dac.bean.Book;

public interface BookDao {

	Integer addBook(Book book);

	Book findById(int bookid);

	List<Book> findAll();

}
