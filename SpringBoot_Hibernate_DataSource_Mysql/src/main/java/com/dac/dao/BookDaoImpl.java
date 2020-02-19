package com.dac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dac.bean.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public Integer addBook(Book book) {
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        Integer id = (Integer) s.save(book);
        s.getTransaction().commit();
        return id;
    }
 
    @SuppressWarnings({ "deprecation", "unchecked" })
    @Override
    public List<Book> findAll() {
        Session s = sessionFactory.getCurrentSession();
        List<Book> list = s.createCriteria(Book.class).list();
        return list;
    }
 
    @Override
    public Book findById(int bookid) {
        Session s = sessionFactory.getCurrentSession();
        Book book = s.get(Book.class, bookid);
        return book;
    }
	
}
