package com.netcracker.dao.daoimpl;

import com.netcracker.dao.BasicDao;
import com.netcracker.dao.idao.IBookDao;
import com.netcracker.model.Book;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("bookDao")
@Transactional
public class BookDaoImpl extends BasicDao implements IBookDao {
    @Override
    public void saveBook(Book book) {
        persist(book);
    }

    @Override
    public List<Book> findAllBooks() {
        return getSession().createCriteria(Book.class).list();
    }

    @Override
    public Book findBookById(int id) {
        return (Book) getSession().get(Book.class, id);
    }

    @Override
    public Book updateBookById(int id, String title, Integer price, String storage, Integer qty) {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.add(Restrictions.eq("id", id));
        Book book = (Book) criteria.uniqueResult();
        if(title != null && !title.equals(""))
            book.setTitle(title);
        if(price != null && price > 0)
            book.setPrice(price);
        if(storage != null && !storage.equals(""))
            book.setTitle(storage);
        if(qty != null && qty >= 0)
            book.setQty(qty);
        update(book);
        return book;
    }

    @Override
    public long getRowsNumber() {
        return (long) getSession().createCriteria(Book.class)
                .setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public List<Book> getBooksWithUniqueTitleAndPrice() {
        SQLQuery query = getSession().createSQLQuery("SELECT DISTINCT title, price FROM books");
        List<Book> books = ((Query) query).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return books;
    }

    @Override
    public List<Book> getBooksWithSpecificTitleOrPrice(String title, double price) {
        SQLQuery query = getSession().createSQLQuery("SELECT title, price FROM books " +
                "WHERE title LIKE :spTitle OR price > :spPrice ORDER BY price DESC");
        query.setParameter("spTitle", "%" + title + "%");
        query.setParameter("spPrice", price);
        List<Book> books = query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return books;
    }

    @Override
    public List<Book> getBooksSoldInTheirStorage() {
        String sqlQuery = "SELECT p.id AS purchase_id, b.title AS book_title, " +
                "b.storage AS storage_district, p.qty AS sold_qty, b.qty AS actual_qty,price " +
                "FROM (purchases p JOIN books b ON p.book_id = b.id) JOIN bookshops s ON p.shop_id = s.id " +
                "WHERE b.storage = s.district AND b.qty > 10 ORDER BY price;";
        SQLQuery query = getSession().createSQLQuery(sqlQuery);
        List<Book> books = query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return books;
    }
}
