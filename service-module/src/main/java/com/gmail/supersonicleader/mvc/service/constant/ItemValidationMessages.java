package com.gmail.supersonicleader.mvc.service.constant;

public interface ItemValidationMessages {

    String NOT_NULL_NAME_MESSAGE = "Name cannot be empty";
    String NAME_SIZE_MESSAGE = "Name length should be from 3 to 40";
    String NAME_REGEXP_MESSAGE = "Name can contain only letters, digits, spaces and punctuation marks, like commas and dots";
    String NOT_NULL_DESCRIPTION_MESSAGE = "Description cannot be empty";
    String DESCRIPTION_SIZE_MESSAGE = "Description length should be from 3 to 100";
    String DESCRIPTION_REGEXP_MESSAGE = "Description can contain only letters, digits, spaces and punctuation marks, like commas and dots";
    String NOT_NULL_PRICE_MESSAGE = "Price cannot be empty";
    String PRICE_FORMAT_MESSAGE = "Price can contain 4 digits before the decimal point and 3 after it";
    String MAX_PRICE_MESSAGE = "Price should be less than 9999";
    String MIN_PRICE_MESSAGE = "Price should be more than 0.01";

}
