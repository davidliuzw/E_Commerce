package com.shop.ecommerce.dao;
// DAO: Data Access Object

import com.shop.ecommerce.entity.Area;

import java.util.List;

// 这是个interface
// 这里没有implements这个interface，而是通过AreaDao.xml来把sql语句和queryArea这个方法map起来？
public interface AreaDao {

    /**
     * this function returns a list of areas
     * @return areaList
     */
    List<Area> queryArea();
    // Areadao.xml文件里声明了queryArea方法，并将其和对应的sql语句map起来

    int insertArea(Area area);
}
