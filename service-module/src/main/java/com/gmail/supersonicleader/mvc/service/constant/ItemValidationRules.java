package com.gmail.supersonicleader.mvc.service.constant;

public interface ItemValidationRules {

    int MIN_NAME_SIZE = 3;
    int MAX_NAME_SIZE = 40;
    String NAME_REGEXP = "^[\\w\\d ,.]*$";
    int MIN_DESCRIPTION_SIZE = 3;
    int MAX_DESCRIPTION_SIZE = 100;
    String DESCRIPTION_REGEXP = "^[\\w\\d ,.]*$";
    int PRICE_INTEGER_PART_SIZE = 5;
    int PRICE_FRACTION_PART_SIZE = 3;
    String MIN_PRICE = "0.0";
    String MAX_PRICE = "99999";

}
