package com.netcracker.dao.daoimpl;

import com.netcracker.dao.BasicDao;
import com.netcracker.dao.idao.IPurchaseDao;
import com.netcracker.model.Purchase;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository("purchaseDao")
@Transactional
public class PurchaseDaoImpl extends BasicDao implements IPurchaseDao {
    @Override
    public void savePurchase(Purchase purchase) {
        persist(purchase);
    }

    @Override
    public List<Purchase> findAllPurchases() {
        return getSession().createCriteria(Purchase.class).list();
    }

    @Override
    public Purchase findPurchaseById(int id) {
        return (Purchase) getSession().get(Purchase.class, id);
    }

    @Override
    public Purchase updatePurchaseById(int id, Date date,
        int shopId, int buyerId, int bookId, int qty, double sum){
        return null;
    }

    @Override
    public long getRowsNumber() {
        return (long) getSession().createCriteria(Purchase.class)
                .setProjection(Projections.rowCount()).uniqueResult();

    }

    @Override
    public List<Purchase> getPurchaseMonths(){
        SQLQuery query = getSession()
                .createSQLQuery("SELECT DISTINCT to_char(date, 'Mon') AS month FROM purchases;");
        List<Purchase> purchases = ((Query) query).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return purchases;
    }

    @Override
    public List<Purchase> getSurnameAndShopNameFromPurchases(){
        SQLQuery query = getSession()
                .createSQLQuery("SELECT p.id AS purchase_id, b.surname AS buyer_surname, s.name AS bookshop_name " +
                                  " FROM purchases p, buyers b, bookshops s " +
                                  "  WHERE p.buyer_id = b.id AND p.shop_id = s.id");
        List<Purchase> purchases = ((Query) query).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return purchases;
    }

    @Override
    public List<Purchase> getDateSurnameDiscountTitleFromPurchases(){
        String sqlQuery = "SELECT p.date AS purchase_date, surname AS buyer_surname, " +
                "discount, b.title AS book_title, p.qty AS qty " +
                    "FROM (purchases p JOIN buyers ON p.buyer_id = buyers.id) JOIN books b ON p.book_id = b.id";
        SQLQuery query = getSession().createSQLQuery(sqlQuery);
        List<Purchase> purchases = ((Query) query).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return purchases;
    }

    @Override
    public List<Purchase> getPurchasesWithSumNotLessThan(double bound){
        SQLQuery query = getSession()
                .createSQLQuery("SELECT p.id, surname, p.date " +
                        "FROM purchases p JOIN buyers ON p.buyer_id = buyers.id " +
                            "WHERE p.sum >= :bound");
        query.setParameter("bound", bound);
        List<Purchase> purchases = ((Query) query).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return purchases;
    }

    @Override
    public List<Purchase> getPurchasesInNativeDistrictSinceMarch() {
        String sqlQuery = "SELECT p.id, p.date, b.surname, b.district " +
                "FROM (purchases p JOIN buyers b ON p.buyer_id = b.id) JOIN bookshops s ON p.shop_id=s.id " +
                "WHERE (b.district = s.district) AND (to_char(p.date, 'MM') >= '03')";
        SQLQuery query = getSession().createSQLQuery(sqlQuery);
        List<Purchase> purchases = query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return purchases;
    }
}
