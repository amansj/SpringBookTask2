package com.task.springbook;

import java.util.List;



//import org.hibernate.LockMode;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;
//import org.hibernate.cfg.Configuration;

import com.task.spring.entity.Book;
import com.task.spring.entity.BookType;

@Transactional 
public class HibernateDao implements Dao {
	//@Autowired
	//SessionFactory factory;
	private HibernateTransactionManager transactionManager;
	public HibernateDao(HibernateTransactionManager transactionManager) {
		super();
		this.transactionManager = transactionManager;
	}
	public HibernateDao() {}
	/*public SessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	public HibernateDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}*/

	@Override
	public String addBookDetails(Book book,String bookType) {
		// TODO Auto-generated method stub
		//Session session=factory.getCurrentSession();
		Session session=transactionManager.getSessionFactory().getCurrentSession();
		try {
			BookType bookT=session.get(BookType.class,bookType);
			if(bookT==null)
			{
				 bookT=new BookType(bookType);
			}
		//	System.out.println(bT.hashCode());
		//	System.out.println(bookT.hashCode());
			//book.setBookType(bookT);
			session.persist(book);
			//session.merge(book);
			//session.persist(book);
		} catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}finally {
			
		}
		return "Successfully Book Added";
	}

	@Override
	public String editBookDetails(Book b,String bookType) {
		// TODO Auto-generated method stub
		//Session session=factory.getCurrentSession();
		Session session=transactionManager.getSessionFactory().getCurrentSession();
		try {
			Book book=session.get(Book.class, b.getId());
			book.setAuthor(b.getAuthor());
			book.setDescription(b.getDescription());
			book.setGenre(b.getGenre());
			book.setPrice(b.getPrice());
			book.setPublish_date(b.getPublish_date());
			book.setTitle(b.getTitle());
			if(bookType!=null)
			{
				BookType bookT=session.get(BookType.class,bookType);
				if(bookT==null)
				{
					bookT=new BookType(bookType);
				}
				//BookType bt=book.getBookType();
				//bt.removeBook(book);
			//	bookT.addBook(book);
			//	session.save(bt);
				session.persist(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "No Such Record Found";
		}finally {
			
		}
		return "Successfully Updated";
	}

	@Override
	public String deleteBookDetails(String BookId) {
		// TODO Auto-generated method stub
		//Session session=factory.getCurrentSession();
		Session session=transactionManager.getSessionFactory().getCurrentSession();
		try {
			Book book=session.get(Book.class, BookId);
			session.delete(book);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "No Such Record Found";
		}
		return "Successfully Deleted";
	}

	@Override
	public Book listBookDetails(String BookId) {
		// TODO Auto-generated method stub
		Session session=transactionManager.getSessionFactory().getCurrentSession();
		Book book=null;
		try {
			
			book=session.get(Book.class, BookId);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
			
		}
		return book;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> displayAll() {
		// TODO Auto-generated method stub
		Session session=transactionManager.getSessionFactory().getCurrentSession();
		List<Book> bList=null;
		//System.out.println(session.isConnected());
		try {		
			bList=(List<Book>)session.createQuery("from Book").list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return bList;
	}

	
	

}
