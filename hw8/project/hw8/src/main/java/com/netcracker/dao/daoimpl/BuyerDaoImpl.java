package com.netcracker.dao.daoimpl;

import com.netcracker.dao.BasicDao;
import com.netcracker.dao.idao.IBuyerDao;
import com.netcracker.model.Buyer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("buyerDao")
@Transactional
public class BuyerDaoImpl extends BasicDao implements IBuyerDao {
    @Override
    public void saveBuyer(Buyer buyer) {
        persist(buyer);
    }

    @Override
    public List<Buyer> findAllBuyers() {
        return getSession().createCriteria(Buyer.class).list();
    }

    @Override
    public Buyer findBuyerById(int id) {
        return (Buyer) getSession().get(Buyer.class, id);
    }

    @Override
    public Buyer updateBuyerById(int id, String surname, String district, Integer discount) {
        Criteria criteria = getSession().createCriteria(Buyer.class);
        criteria.add(Restrictions.eq("id", id));
        Buyer buyer = (Buyer) criteria.uniqueResult();
        if(surname != null && !surname.equals(""))
            buyer.setSurname(surname);
        if(district != null && !district.equals(""))
            buyer.setDistrict(district);
        if(discount != null && discount >= 0)
            buyer.setDiscount(discount);
        update(buyer);
        return buyer;
    }

    @Override
    public long getRowsNumber() {
        return (long) getSession().createCriteria(Buyer.class)
                .setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public List<Buyer> getInhabitedDistricts(){
        SQLQuery query = getSession().createSQLQuery("SELECT DISTINCT district FROM buyers");
        List<Buyer> buyers = ((Query) query).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return buyers;
    }

    @Override
    public List<Buyer> getBuyersFromDistrict(String district) {
        Criteria criteria = getSession().createCriteria(Buyer.class);
        criteria.add(Restrictions.like("district", district));
        return criteria.list();
    }
}
