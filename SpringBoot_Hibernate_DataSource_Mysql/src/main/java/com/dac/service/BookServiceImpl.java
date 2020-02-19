package com.dac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dac.bean.Book;
import com.dac.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public int addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Override
	public Book findById(int bookid) {
		return bookDao.findById(bookid);
	}

}
