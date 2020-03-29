package com.gmail.supersonicleader.mvc.repository.impl;

import com.gmail.supersonicleader.mvc.repository.ShopRepository;
import com.gmail.supersonicleader.mvc.repository.model.Shop;
import org.springframework.stereotype.Repository;

@Repository
public class ShopRepositoryImpl extends GenericRepositoryImpl<Long, Shop> implements ShopRepository {
}
