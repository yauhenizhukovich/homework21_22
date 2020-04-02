package com.gmail.supersonicleader.mvc.repository.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.gmail.supersonicleader.mvc.repository.ItemRepository;
import com.gmail.supersonicleader.mvc.repository.model.Item;
import com.gmail.supersonicleader.mvc.repository.model.ItemDetails;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl extends GenericRepositoryImpl<Long, Item> implements ItemRepository {

    @Override
    @SuppressWarnings("unchecked")
    public List<Item> getItemsByName(String name) {
        String queryString =
                "FROM " + entityClass.getSimpleName() + " e WHERE e.name=:name";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("name", name);
        return (List<Item>) query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ItemDetails> getItemDetailsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        String queryString = "FROM ItemDetails e WHERE e.price BETWEEN :minPrice AND :maxPrice";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        return (List<ItemDetails>) query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Item getItemByItemDetails(ItemDetails itemDetails) {
        String queryString = "FROM " + entityClass.getSimpleName() + " e WHERE e.itemDetails=:itemDetails";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("itemDetails", itemDetails);
        return (Item) query.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Item getItemByNameAndItemDetails(String name, ItemDetails itemDetails) {
        String queryString =
                "FROM " + entityClass.getSimpleName() + " e WHERE e.name=:name AND e.itemDetails=:itemDetails";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("name", name);
        query.setParameter("itemDetails", itemDetails);
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        } else {
            return (Item) results.get(0);
        }
    }

}
