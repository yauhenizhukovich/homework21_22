package com.gmail.supersonicleader.mvc.web.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
import org.springframework.web.bind.annotation.RequestParam;

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

    /*@GetMapping
    public String getAllShops(
            @RequestParam Integer pageNumber,
            Model model
    ) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        int countOfPages = shopService.getCountOfPages();
        if (countOfPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, countOfPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        List<ShopDTO> shops = shopService.findShopsByPage(pageNumber);
        model.addAttribute("shops", shops);
        return "shops";
    }*/

    @GetMapping("/filter")
    public String getFilteredShops(
            @RequestParam String location,
            Model model
    ) {
        List<ShopDTO> shops = shopService.findFilteredShops(location);
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
