package com.gmail.supersonicleader.mvc.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import com.gmail.supersonicleader.mvc.service.ItemService;
import com.gmail.supersonicleader.mvc.service.ShopService;
import com.gmail.supersonicleader.mvc.service.model.AddItemDTO;
import com.gmail.supersonicleader.mvc.service.model.FindAllItemDTO;
import com.gmail.supersonicleader.mvc.service.model.GetItemDTO;
import com.gmail.supersonicleader.mvc.service.model.ShopDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final ShopService shopService;

    public ItemController(ItemService itemService, ShopService shopService) {
        this.itemService = itemService;
        this.shopService = shopService;
    }

    @GetMapping
    public String getAllItems(Model model) {
        List<FindAllItemDTO> items = itemService.findAllItems();
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("/add")
    public String addItemWithLinkedShop(Model model) {
        List<ShopDTO> shops = shopService.findAllShops();
        model.addAttribute("item", new AddItemDTO());
        model.addAttribute("shops", shops);
        return "add_item";
    }

    @PostMapping("/add")
    public String addItemWithLinkedShop(
            @ModelAttribute(name = "item") @Valid AddItemDTO item,
            @RequestParam Long[] shopIds,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("item", item);
            return "add_item";
        } else {
            List<Long> shopsIds = Arrays.asList(shopIds);
            item.setShopsIds(shopsIds);
            itemService.addItemWithLinkedShop(item);
            return "redirect:/items";
        }
    }

    @GetMapping("/{id}")
    public String getItemWithLinkedShopById(@PathVariable Long id, Model model) {
        GetItemDTO item = itemService.getItemWithLinkedShopById(id);
        model.addAttribute("item", item);
        return "item";
    }

    @GetMapping("/{id}/delete")
    public String deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return "redirect:/items";
    }

}
