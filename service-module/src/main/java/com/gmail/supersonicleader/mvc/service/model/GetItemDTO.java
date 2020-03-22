package com.gmail.supersonicleader.mvc.service.model;

import java.math.BigDecimal;
import java.util.List;

public class GetItemDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<ShopDTO> shops;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setShops(List<ShopDTO> shops) {
        this.shops = shops;
    }

    public List<ShopDTO> getShops() {
        return shops;
    }

}
