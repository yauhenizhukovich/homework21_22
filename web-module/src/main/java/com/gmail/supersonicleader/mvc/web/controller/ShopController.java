package com.gmail.supersonicleader.mvc.web.controller;

import java.util.List;
import javax.validation.Valid;

import com.gmail.supersonicleader.mvc.service.ShopService;
import com.gmail.supersonicleader.mvc.service.model.ShopDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {this.shopService = shopService;}

    @GetMapping
    public String getAllShops(Model model) {
        List<ShopDTO> shops = shopService.findAllShops();
        model.addAttribute("shops", shops);
        return "shops";
    }

    @GetMapping("/add")
    public String addShop(Model model) {
        model.addAttribute("shop", new ShopDTO());
        return "add_shop";
    }

    @PostMapping("/add")
    public String addShop(
            @ModelAttribute(name = "shop") @Valid ShopDTO shop,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("shop", shop);
            return "add_shop";
        } else {
            shopService.addShop(shop);
            return "redirect:/shops";
        }
    }

}
