package com.task.springbook;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.List;

import com.task.spring.entity.Book;

public class HibernateService implements Service {
	Dao dao;
	public HibernateService() {
		// TODO Auto-generated constructor stub
		
	}
	HibernateService(Dao dao)
	{
		this.dao=dao;
	}
	@Override
	public String add(Book book,String bookType) {
		// TODO Auto-generated method stub
		/*String date=book.getPublish_date();
		LocalDate datep=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String nDate=datep.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
		book.setPublish_date(nDate);*/
		return dao.addBookDetails(book,bookType);
	}

	@Override
	public String edit(Book book,String bookType) {
		// TODO Auto-generated method stub
	/*	String date=book.getPublish_date();
		String nDate="";
		int index=date.indexOf(" ");
		if(index<0)
		{
			LocalDate datep=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			nDate=datep.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
		}
		else
		{
			LocalDateTime datetime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			nDate=datetime.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
		}
		book.setPublish_date(nDate);*/
		return dao.editBookDetails(book,bookType);
	}

	@Override
	public String delete(String bookId) {
		// TODO Auto-generated method stub
		return dao.deleteBookDetails(bookId);
	}

	@Override
	public Book list(String bookId) {
		// TODO Auto-generated method stub
		return dao.listBookDetails(bookId);
	}

	@Override
	public List<Book> display() {
		// TODO Auto-generated method stub
		return dao.displayAll();
	}

}
