package com.gmail.supersonicleader.mvc.service.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.gmail.supersonicleader.mvc.service.constant.ShopDTOConstant.LOCATION_REGEXP;
import static com.gmail.supersonicleader.mvc.service.constant.ShopDTOConstant.LOCATION_REGEXP_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.ShopDTOConstant.LOCATION_SIZE_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.ShopDTOConstant.MAX_LOCATION_SIZE;
import static com.gmail.supersonicleader.mvc.service.constant.ShopDTOConstant.MAX_NAME_SIZE;
import static com.gmail.supersonicleader.mvc.service.constant.ShopDTOConstant.MIN_LOCATION_SIZE;
import static com.gmail.supersonicleader.mvc.service.constant.ShopDTOConstant.MIN_NAME_SIZE;
import static com.gmail.supersonicleader.mvc.service.constant.ShopDTOConstant.NAME_REGEXP;
import static com.gmail.supersonicleader.mvc.service.constant.ShopDTOConstant.NAME_REGEXP_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.ShopDTOConstant.NAME_SIZE_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.ShopDTOConstant.NOT_NULL_LOCATION_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.ShopDTOConstant.NOT_NULL_NAME_MESSAGE;

public class ShopDTO {

    private Long id;
    @NotNull(message = NOT_NULL_NAME_MESSAGE)
    @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE, message = NAME_SIZE_MESSAGE)
    @Pattern(regexp = NAME_REGEXP, message = NAME_REGEXP_MESSAGE)
    private String name;
    @NotNull(message = NOT_NULL_LOCATION_MESSAGE)
    @Size(min = MIN_LOCATION_SIZE, max = MAX_LOCATION_SIZE, message = LOCATION_SIZE_MESSAGE)
    @Pattern(regexp = LOCATION_REGEXP, message = LOCATION_REGEXP_MESSAGE)
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
