package com.gmail.supersonicleader.mvc.service.constant;

public interface ShopValidationRules {

    int MIN_NAME_SIZE = 3;
    int MAX_NAME_SIZE = 40;
    String NAME_REGEXP = "^[\\w\\d ,.]*$";
    int MIN_LOCATION_SIZE = 3;
    int MAX_LOCATION_SIZE = 100;
    String LOCATION_REGEXP = "^[\\w\\d ,.]*$";
}
