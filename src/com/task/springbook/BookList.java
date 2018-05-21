package com.task.springbook;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.task.spring.entity.Book;


@XmlRootElement(name = "books")
@XmlAccessorType (XmlAccessType.FIELD)
public class BookList {
	@XmlElement(name = "book")
    private List<Book> books ;
    public BookList()
    {
    	books=new ArrayList<Book>();
    }
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}   
}
