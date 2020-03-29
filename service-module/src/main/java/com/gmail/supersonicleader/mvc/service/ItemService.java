package com.gmail.supersonicleader.mvc.service;

import java.util.List;

import com.gmail.supersonicleader.mvc.service.model.AddItemDTO;
import com.gmail.supersonicleader.mvc.service.model.FindAllItemDTO;
import com.gmail.supersonicleader.mvc.service.model.GetItemDTO;

public interface ItemService {

    List<FindAllItemDTO> findAllItems();

    GetItemDTO getItemWithLinkedShopById(Long id);

    void addItemWithLinkedShop(AddItemDTO item);

    void deleteItemById(Long id);

}
