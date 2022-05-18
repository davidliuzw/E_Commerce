package com.shop.ecommerce.service;

import com.shop.ecommerce.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopService {

    int insertShop(Shop shop);

    int updateShop(Shop shop);

    Shop queryByShopId(long shopId);

    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
                             @Param("pageSize") int pageSize);

    int queryShopCount(@Param("shopCondition") Shop shopCondition);
}
