package com.task.springbook;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import com.task.spring.entity.Book;

@Component
public class XMLDao implements Dao {

	private JAXBContext jaxbContext;
	private BookList bList;
	
	public XMLDao()
	{
		
		
	}
	public void marshall() 
	{
		try {
			Marshaller ms=jaxbContext.createMarshaller();
			ms.marshal(bList, new File("book2.xml"));
		} catch (JAXBException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	private void unmarshaller()
	{
		 try {
			 File file = new File("book.xml");
			
			;
			 jaxbContext = JAXBContext.newInstance(com.task.springbook.BookList.class);                                     
	         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	         bList = (BookList) jaxbUnmarshaller.unmarshal(file);
	         
		} catch (JAXBException e) {
			// TODO: handle exception
			System.out.println(e);
		} 
	}
	@Override
	public String addBookDetails(Book book,String bookType) {
		// TODO Auto-generated method stub
		unmarshaller();
		if(search(book.getId())==-1)
		{
			bList.getBooks().add(book);
			marshall();
			bList=null;
			return "Successfully Book Added";
		}
		else
		{
			bList=null;
			return "Book Id Already Exist";
		}	
	}

	@Override
	public String editBookDetails(Book b,String bookType) {
		// TODO Auto-generated method stub
		unmarshaller();
		int index=search(b.getId());
		if(index!=-1)
		{
			bList.getBooks().remove(index);
			bList.getBooks().add(index, b);
			marshall();
			bList=null;
			return "Successfully Updated";
		}
		else {
			bList=null;
			return "No Such Record Found";
		}
	}

	@Override
	public String deleteBookDetails(String BookId) {
		// TODO Auto-generated method stub
		unmarshaller();
		int index=search(BookId);
		if(index!=-1)
		{
			bList.getBooks().remove(index);
			marshall();
			bList=null;
			return "Successfully Deleted";
		}
		else {
			bList=null;
			return "No Such Record Found";
		}
		
	}

	@Override
	public Book listBookDetails(String BookId) {
		// TODO Auto-generated method stub
		unmarshaller();
		int index=search(BookId);
		if(index!=-1)
		{
			Book book=bList.getBooks().get(index);
			bList=null;
			return book;
		}
		else {
			bList=null;
			return null;
		}
		
	}

	@Override
	public List<Book> displayAll() {
		// TODO Auto-generated method stub
		unmarshaller();
		if(bList==null)
		{
			return null;
		}
		List<Book> bookList=bList.getBooks();
		bList=null;
		return bookList;
	}
	

	
	public int search(String BookId) {
		// TODO Auto-generated method stub
		for(int i=0;i<bList.getBooks().size();i++)
		{
			if(bList.getBooks().get(i).getId().equals(BookId))
			{
				return i;
			}
		}
		return -1;
	}
}
