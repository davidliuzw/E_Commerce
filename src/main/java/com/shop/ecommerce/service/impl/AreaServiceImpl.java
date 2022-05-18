package com.shop.ecommerce.service.impl;

import com.shop.ecommerce.dao.AreaDao;
import com.shop.ecommerce.entity.Area;
import com.shop.ecommerce.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// service里的方法是直接暴露给用户的？
@Service
// 这个东西有说法的，指明了这是提供service的layer
// 在哪里调用了这个service啊， controller里直接就implement了一个AreaService？
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    // 为什么是private ?

    @Override
    // 这里指明要override是为什么？override areaservice里的这个函数
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    public int addArea(Area area) { return areaDao.insertArea(area);}
}
