package com.gmail.supersonicleader.mvc.service.constant;

import java.math.BigDecimal;

public interface AddItemDTOConstant {

    int MIN_NAME_SIZE = 3;
    int MAX_NAME_SIZE = 40;
    String NAME_REGEXP = "^[\\w\\d ,.]*$";
    int MIN_DESCRIPTION_SIZE = 3;
    int MAX_DESCRIPTION_SIZE = 100;
    String DESCRIPTION_REGEXP = "^[\\w\\d ,.]*$";
    String MIN_PRICE = "0.01";
    String MAX_PRICE = "1000";

    String NOT_NULL_NAME_MESSAGE = "Name cannot be empty";
    String NAME_SIZE_MESSAGE = "Name length should be from 3 to 40";
    String NAME_REGEXP_MESSAGE = "Name can contain only letters, digits, spaces and punctuation marks, like commas and dots";
    String NOT_NULL_DESCRIPTION_MESSAGE = "Description cannot be empty";
    String DESCRIPTION_SIZE_MESSAGE = "Description length should be from 3 to 100";
    String DESCRIPTION_REGEXP_MESSAGE = "Description can contain only letters, digits, spaces and punctuation marks, like commas and dots";
    String NOT_NULL_PRICE_MESSAGE = "Price cannot be empty";
    String MAX_PRICE_MESSAGE = "Price should be less than 1000";
    String MIN_PRICE_MESSAGE = "Price should be more than 0.01";

}
