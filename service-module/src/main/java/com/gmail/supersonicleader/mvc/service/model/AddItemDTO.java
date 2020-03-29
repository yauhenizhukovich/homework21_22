package com.gmail.supersonicleader.mvc.service.model;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.DESCRIPTION_REGEXP;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.DESCRIPTION_REGEXP_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.DESCRIPTION_SIZE_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.MAX_DESCRIPTION_SIZE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.MAX_NAME_SIZE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.MAX_PRICE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.MAX_PRICE_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.MIN_DESCRIPTION_SIZE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.MIN_NAME_SIZE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.MIN_PRICE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.MIN_PRICE_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.NAME_REGEXP;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.NAME_REGEXP_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.NAME_SIZE_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.NOT_NULL_DESCRIPTION_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.NOT_NULL_NAME_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.AddItemDTOConstant.NOT_NULL_PRICE_MESSAGE;

public class AddItemDTO {

    @NotNull(message = NOT_NULL_NAME_MESSAGE)
    @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE, message = NAME_SIZE_MESSAGE)
    @Pattern(regexp = NAME_REGEXP, message = NAME_REGEXP_MESSAGE)
    private String name;
    @NotNull(message = NOT_NULL_DESCRIPTION_MESSAGE)
    @Size(min = MIN_DESCRIPTION_SIZE, max = MAX_DESCRIPTION_SIZE, message = DESCRIPTION_SIZE_MESSAGE)
    @Pattern(regexp = DESCRIPTION_REGEXP, message = DESCRIPTION_REGEXP_MESSAGE)
    private String description;
    @NotNull(message = NOT_NULL_PRICE_MESSAGE)
    @DecimalMin(value = MIN_PRICE, message = MIN_PRICE_MESSAGE)
    @DecimalMax(value = MAX_PRICE, message = MAX_PRICE_MESSAGE)
    private BigDecimal price;
    private List<Long> shopIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Long> getShopIds() {
        return shopIds;
    }

    public void setShopsIds(List<Long> shopIds) {
        this.shopIds = shopIds;
    }

}
