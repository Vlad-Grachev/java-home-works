package com.netcracker.dao.daoimpl;

import com.netcracker.dao.BasicDao;
import com.netcracker.dao.idao.IBookshopDao;
import com.netcracker.model.Bookshop;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("bookshopDao")
@Transactional
public class BookshopDaoImpl extends BasicDao implements IBookshopDao {
    @Override
    public void saveBookshop(Bookshop bookshop) {
        persist(bookshop);
    }

    @Override
    public List<Bookshop> findAllBookshops() {
        return getSession().createCriteria(Bookshop.class).list();
    }

    @Override
    public Bookshop findBookshopById(int id) {
        return (Bookshop) getSession().get(Bookshop.class, id);
    }

    @Override
    public Bookshop updateBookshopById(int id, String name, String district, Integer comission) {
        Criteria criteria = getSession().createCriteria(Bookshop.class);
        criteria.add(Restrictions.eq("id", id));
        Bookshop bookshop = (Bookshop) criteria.uniqueResult();
        if(name != null && !name.equals(""))
            bookshop.setName(name);
        if(district != null && !district.equals(""))
            bookshop.setDistrict(district);
        if(comission != null && comission >= 0)
            bookshop.setCommission(comission);
        update(bookshop);
        return bookshop;
    }

    @Override
    public long getRowsNumber() {
        return (long) getSession().createCriteria(Bookshop.class)
                .setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public List<Bookshop> getBookshopsFromSpecificDistricts(String... distritcs) {
        SQLQuery query = getSession()
                .createSQLQuery("SELECT name FROM bookshops WHERE district IN (:spValues)");
        query.setParameterList("spValues", distritcs);
        List<Bookshop> bookshops = query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return bookshops;
    }

    @Override
    public List<Bookshop> getBookshopsWithRestrictsOnDistrictAndBuyerDiscount(
            String exceptDisctrict, int lowDiscountBound, int upDiscountBound){
        String sqlQuery = "SELECT s.id AS shop_id, s.name AS shop_name, s.district AS shop_district, " +
                "b.discount AS buyer_discount, p.id AS purchase_id\n" +
                "FROM (purchases p JOIN buyers b ON p.buyer_id = b.id) JOIN bookshops s ON p.shop_id=s.id " +
                "WHERE (s.district != :exc) AND (b.discount > :lowb AND b.discount < :upb)";
        SQLQuery query = getSession().createSQLQuery(sqlQuery);
        query.setParameter("exc", exceptDisctrict);
        query.setParameter("lowb", lowDiscountBound);
        query.setParameter("upb", upDiscountBound);
        List<Bookshop> bookshops = query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return bookshops;
    }
}
