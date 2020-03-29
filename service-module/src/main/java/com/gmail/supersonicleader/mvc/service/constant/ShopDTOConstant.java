package com.gmail.supersonicleader.mvc.service.constant;

public interface ShopDTOConstant {

    int MIN_NAME_SIZE = 3;
    int MAX_NAME_SIZE = 40;
    String NAME_REGEXP = "^[\\w\\d ,.]*$";
    int MIN_LOCATION_SIZE = 3;
    int MAX_LOCATION_SIZE = 100;
    String LOCATION_REGEXP = "^[\\w\\d ,.]*$";

    String NOT_NULL_NAME_MESSAGE = "Name cannot be empty";
    String NAME_SIZE_MESSAGE = "Name length should be from 3 to 40";
    String NAME_REGEXP_MESSAGE = "Name can contain only letters, digits, spaces and punctuation marks, like commas and dots";
    String NOT_NULL_LOCATION_MESSAGE = "Location cannot be empty";
    String LOCATION_SIZE_MESSAGE = "Location length should be from 3 to 100";
    String LOCATION_REGEXP_MESSAGE = "Location can contain only letters, digits, spaces and punctuation marks, like commas and dots";

}
