package com.task.springbook;

import java.util.List;

import com.task.spring.entity.Book;

public interface Dao {
	public String addBookDetails(Book book,String bookType);
	public String editBookDetails(Book book,String bookType);
	public String deleteBookDetails(String BookId);
	public Book listBookDetails(String BookId);
	public List<Book> displayAll(); 
}
