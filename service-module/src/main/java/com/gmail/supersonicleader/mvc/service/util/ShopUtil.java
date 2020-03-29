package com.gmail.supersonicleader.mvc.service.util;

public class ShopUtil {

    public static final int OBJECTS_BY_PAGE = 5;

    public static int getStartPositionByPage(int pageNumber) {
        return (pageNumber - 1) * OBJECTS_BY_PAGE + 1;
    }

}
