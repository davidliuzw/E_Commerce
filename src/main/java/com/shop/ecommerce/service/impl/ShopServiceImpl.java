package com.shop.ecommerce.service.impl;

import com.shop.ecommerce.dao.ShopDao;
import com.shop.ecommerce.entity.Shop;
import com.shop.ecommerce.service.ShopService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public int insertShop(Shop shop) {return shopDao.insertShop(shop);}
    @Override
    public int updateShop(Shop shop) {return shopDao.updateShop(shop);}
    @Override
    public Shop queryByShopId(long shopId) {return shopDao.queryByShopId(shopId);}
    @Override
    public List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
                             @Param("pageSize") int pageSize) {
        return shopDao.queryShopList(shopCondition, rowIndex, pageSize);
    }
    @Override
    public int queryShopCount(@Param("shopCondition") Shop shopCondition) {
        return shopDao.queryShopCount(shopCondition);
    }
}
