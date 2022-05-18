package com.shop.ecommerce.service;

import com.shop.ecommerce.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//
public interface ProductService {
    List<Product> queryProductList(@Param("productCondition") Product productCondition, @Param("rowIndex") int beginIndex,
                                   @Param("pageSize") int pageSize);

    int queryProductCount(@Param("productCondition") Product productCondition);

    Product queryProductById(long productId);
}
