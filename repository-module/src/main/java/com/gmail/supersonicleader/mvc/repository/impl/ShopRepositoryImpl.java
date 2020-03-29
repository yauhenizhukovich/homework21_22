package com.gmail.supersonicleader.mvc.repository.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import com.gmail.supersonicleader.mvc.repository.ShopRepository;
import com.gmail.supersonicleader.mvc.repository.model.Shop;
import org.springframework.stereotype.Repository;

@Repository
public class ShopRepositoryImpl extends GenericRepositoryImpl<Long, Shop> implements ShopRepository {

    @Override
    public List<Shop> getShopsByLocation(String location) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Shop> query = builder.createQuery(entityClass);
        Root<Shop> shop = query.from(entityClass);
        ParameterExpression<String> parameterExpression = builder.parameter(String.class);
        query.select(shop)
                .where(builder.equal(shop.get("location"), parameterExpression));
        TypedQuery<Shop> typedQuery = entityManager.createQuery(query);
        typedQuery.setParameter(parameterExpression, location);
        return typedQuery.getResultList();
    }

    @Override
    public int getCountOfShops() {
        String queryString = "SELECT COUNT(*) FROM " + entityClass.getSimpleName();
        Query query = entityManager.createQuery(queryString);
        return (int) query.getSingleResult();
    }

}
