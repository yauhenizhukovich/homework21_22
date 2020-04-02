package com.gmail.supersonicleader.mvc.service.constant;

public interface ShopValidationMessages {

    String NOT_NULL_NAME_MESSAGE = "Name cannot be empty";
    String NAME_SIZE_MESSAGE = "Name length should be from 3 to 40";
    String NAME_REGEXP_MESSAGE = "Name can contain only letters, digits, spaces and punctuation marks, like commas and dots";
    String NOT_NULL_LOCATION_MESSAGE = "Location cannot be empty";
    String LOCATION_SIZE_MESSAGE = "Location length should be from 3 to 100";
    String LOCATION_REGEXP_MESSAGE = "Location can contain only letters, digits, spaces and punctuation marks, like commas and dots";

}
