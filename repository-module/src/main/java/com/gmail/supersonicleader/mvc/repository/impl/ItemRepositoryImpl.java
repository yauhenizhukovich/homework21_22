package com.gmail.supersonicleader.mvc.repository.impl;

import com.gmail.supersonicleader.mvc.repository.ItemRepository;
import com.gmail.supersonicleader.mvc.repository.model.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl extends GenericRepositoryImpl<Long, Item> implements ItemRepository {
}
