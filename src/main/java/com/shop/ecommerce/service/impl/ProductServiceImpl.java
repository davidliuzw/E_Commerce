package com.shop.ecommerce.service.impl;

import com.shop.ecommerce.dao.ProductDao;
import com.shop.ecommerce.entity.Product;
import com.shop.ecommerce.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    // 本来这里写了@override但他说我写的其实没有override所以我给删了
    // 我也不知道应不应该留着@Para，函数里有@Param("productCondition") Product这些都报错，我就给删了
    // 好像删了也行，service里可以删掉，controller里必须要有
    public List<Product> queryProductList(Product productCondition, int beginIndex, int pageSize) {
        return productDao.queryProductList(productCondition, beginIndex, pageSize);
    }

    public int queryProductCount(Product productCondition) {
        return productDao.queryProductCount(productCondition);
    }

    public Product queryProductById(long productId) {
        return productDao.queryProductById(productId);
    }
}
