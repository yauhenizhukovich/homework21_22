package com.gmail.supersonicleader.mvc.service;

import java.util.List;

import com.gmail.supersonicleader.mvc.service.model.ShopDTO;

public interface ShopService {

    List<ShopDTO> findAllShops();

    void addShop(ShopDTO shopDTO);

}
