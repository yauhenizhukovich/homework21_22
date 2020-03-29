package com.gmail.supersonicleader.mvc.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.gmail.supersonicleader.mvc.repository.ItemRepository;
import com.gmail.supersonicleader.mvc.repository.ShopRepository;
import com.gmail.supersonicleader.mvc.repository.model.Item;
import com.gmail.supersonicleader.mvc.repository.model.ItemDetails;
import com.gmail.supersonicleader.mvc.repository.model.Shop;
import com.gmail.supersonicleader.mvc.service.ItemService;
import com.gmail.supersonicleader.mvc.service.model.AddItemDTO;
import com.gmail.supersonicleader.mvc.service.model.FindAllItemDTO;
import com.gmail.supersonicleader.mvc.service.model.GetItemDTO;
import com.gmail.supersonicleader.mvc.service.model.ShopDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ShopRepository shopRepository;

    public ItemServiceImpl(ItemRepository itemRepository, ShopRepository shopRepository) {
        this.itemRepository = itemRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    @Transactional
    public List<FindAllItemDTO> findAllItems() {
        List<Item> items = itemRepository.findAll();
        List<FindAllItemDTO> itemsDTO = items.stream()
                .map(this::convertItemToDTOToFindAll)
                .collect(Collectors.toList());
        return itemsDTO;
    }

    @Override
    @Transactional
    public GetItemDTO getItemWithLinkedShopById(Long id) {
        Item item = itemRepository.findById(id);
        GetItemDTO itemDTO = convertItemToDTOToGet(item);
        return itemDTO;
    }

    @Override
    @Transactional
    public void addItemWithLinkedShop(AddItemDTO itemDTO) {
        Item item = convertDTOToItemToAdd(itemDTO);
        itemRepository.add(item);
    }

    @Override
    @Transactional
    public void deleteItemById(Long id) {
        Item item = itemRepository.findById(id);
        itemRepository.delete(item);
    }

    private FindAllItemDTO convertItemToDTOToFindAll(Item item) {
        FindAllItemDTO itemDTO = new FindAllItemDTO();
        Long id = item.getId();
        itemDTO.setId(id);
        String name = item.getName();
        itemDTO.setName(name);
        String description = item.getDescription();
        itemDTO.setDescription(description);
        BigDecimal price = getPriceForDTO(item);
        itemDTO.setPrice(price);
        return itemDTO;
    }

    private GetItemDTO convertItemToDTOToGet(Item item) {
        GetItemDTO itemDTO = new GetItemDTO();
        Long id = item.getId();
        itemDTO.setId(id);
        String name = item.getName();
        itemDTO.setName(name);
        String description = item.getDescription();
        itemDTO.setDescription(description);
        BigDecimal price = getPriceForDTO(item);
        itemDTO.setPrice(price);
        List<ShopDTO> shopsDTO = getShopsForDTO(item);
        itemDTO.setShops(shopsDTO);
        return itemDTO;
    }

    private Item convertDTOToItemToAdd(AddItemDTO itemDTO) {
        Item item = new Item();
        String name = itemDTO.getName();
        item.setName(name);
        String description = itemDTO.getDescription();
        item.setDescription(description);
        ItemDetails itemDetails = getItemDetailsForDatabaseObject(itemDTO, item);
        item.setItemDetails(itemDetails);
        List<Shop> shops = getShopsForDatabaseObject(itemDTO);
        item.setShops(shops);
        return item;
    }

    private BigDecimal getPriceForDTO(Item item) {
        ItemDetails itemDetails = item.getItemDetails();
        BigDecimal price = null;
        if (itemDetails != null) {
            price = itemDetails.getPrice();
        }
        return price;
    }

    private List<ShopDTO> getShopsForDTO(Item item) {
        List<Shop> shops = item.getShops();
        return shops.stream()
                .map(this::convertShopToDTO)
                .collect(Collectors.toList());
    }

    private ItemDetails getItemDetailsForDatabaseObject(AddItemDTO itemDTO, Item item) {
        BigDecimal price = itemDTO.getPrice();
        ItemDetails itemDetails = new ItemDetails();
        itemDetails.setPrice(price);
        itemDetails.setItem(item);
        return itemDetails;
    }

    private List<Shop> getShopsForDatabaseObject(AddItemDTO itemDTO) {
        List<Long> shopIds = itemDTO.getShopIds();
        return shopIds.stream()
                .map(shopRepository::findById)
                .collect(Collectors.toList());
    }

    private ShopDTO convertShopToDTO(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        String name = shop.getName();
        shopDTO.setName(name);
        String location = shop.getLocation();
        shopDTO.setLocation(location);
        return shopDTO;
    }

}
