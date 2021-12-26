package com.crud.demo.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.dao.BookDao;
import com.crud.demo.model.Book;
import com.crud.demo.model.Sale;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	public Book saveBook(Book book) {
		return bookDao.save(book);
	}
	
	public List<Book> getBooks(){
		return bookDao.findAll();
	}
	
	public Book getBook(int id) {
		return bookDao.findById(id).orElse(null);
	}
	
	public Book updateBook(Book book) {
		Book b = bookDao.findById(book.getBook_id()).orElse(null);
		b.setBook_name(book.getBook_name());
		b.setAuthor(book.getAuthor());
		b.setGenre(book.getGenre());
		return bookDao.save(b);
	}
	
	public void deleteBook(int id) {
		bookDao.deleteById(id);
	}
	
	public String maxSold() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
		Root<Book> root = cq.from(Book.class);
		cq.select(root.get("book_id")).where(cb.equal(root.get("genre"), "Software Architecture"));
		
		List<Integer> books = em.createQuery(cq).getResultList();
		int mx=0, bId=0;
		
		for(int id: books) {
			CriteriaBuilder saleBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Integer> saleQuery = cb.createQuery(Integer.class);
			Root<Sale> saleRoot = saleQuery.from(Sale.class);
			saleQuery.select(saleRoot.get("sale_id")).where(saleBuilder.equal(saleRoot.get("book_id"), id));
			List<Integer> saleList = em.createQuery(saleQuery).getResultList();
			
			if(mx<saleList.size()) {
				mx=saleList.size();
				bId=id;
			}
		}
		
		CriteriaQuery<String> nq = cb.createQuery(String.class);
		Root<Book> nr = nq.from(Book.class);
		nq.select(nr.get("book_name")).where(cb.equal(nr.get("book_id"), bId));
		String bookName = em.createQuery(nq).getSingleResult();
		return bookName;
	}
}
