package com.gmail.supersonicleader.mvc.repository;

import java.math.BigDecimal;
import java.util.List;

import com.gmail.supersonicleader.mvc.repository.model.Item;
import com.gmail.supersonicleader.mvc.repository.model.ItemDetails;

public interface ItemRepository extends GenericRepository<Long, Item> {

    List<Item> getItemsByName(String name);

    List<ItemDetails> getItemDetailsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

    Item getItemByItemDetails(ItemDetails itemDetails);

    Item getItemByNameAndItemDetails(String name, ItemDetails itemDetails);

}
