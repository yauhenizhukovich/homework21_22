package com.gmail.supersonicleader.mvc.service;

import java.util.List;

import com.gmail.supersonicleader.mvc.service.model.ShopDTO;
import org.springframework.transaction.annotation.Transactional;

public interface ShopService {

    List<ShopDTO> findAllShops();

    void addShop(ShopDTO shopDTO);

    @Transactional
    List<ShopDTO> findShopsByPage(int pageNumber);

    List<ShopDTO> findFilteredShops(String location);

    int getCountOfPages();

}
