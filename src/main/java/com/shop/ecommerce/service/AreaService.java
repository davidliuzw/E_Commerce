package com.shop.ecommerce.service;

import com.shop.ecommerce.entity.Area;

import java.util.List;

// 这个是接口，里面的method没有body，需要另一个class来implement这个interface
// 比如AreaServiceImpl就implements来AreaService这个interface
public interface AreaService {
    /**
     * get all areas
     * @return
     */
    List<Area> getAreaList();

    int addArea(Area area);
}
