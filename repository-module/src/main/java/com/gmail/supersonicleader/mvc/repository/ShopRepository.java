package com.gmail.supersonicleader.mvc.repository;

import java.util.List;

import com.gmail.supersonicleader.mvc.repository.model.Shop;

public interface ShopRepository extends GenericRepository<Long, Shop> {

    List<Shop> getShopsByLocation(String location);

    int getCountOfShops();

}
