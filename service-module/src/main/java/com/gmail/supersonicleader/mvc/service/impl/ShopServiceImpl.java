package com.gmail.supersonicleader.mvc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.gmail.supersonicleader.mvc.repository.ShopRepository;
import com.gmail.supersonicleader.mvc.repository.model.Shop;
import com.gmail.supersonicleader.mvc.service.ShopService;
import com.gmail.supersonicleader.mvc.service.model.ShopDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {this.shopRepository = shopRepository;}

    @Override
    @Transactional
    public List<ShopDTO> findAllShops() {
        List<Shop> shops = shopRepository.findAll();
        return shops.stream()
                .map(this::convertShopToDTOToFindAll)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addShop(ShopDTO shopDTO) {
        Shop shop = convertDTOToShopToAdd(shopDTO);
        shopRepository.add(shop);
    }

    private Shop convertDTOToShopToAdd(ShopDTO shopDTO) {
        Shop shop = new Shop();
        String name = shopDTO.getName();
        shop.setName(name);
        String location = shopDTO.getLocation();
        shop.setLocation(location);
        return shop;
    }

    private ShopDTO convertShopToDTOToFindAll(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        String name = shop.getName();
        shopDTO.setName(name);
        String location = shop.getLocation();
        shopDTO.setLocation(location);
        Long id = shop.getId();
        shopDTO.setId(id);
        return shopDTO;
    }

}
