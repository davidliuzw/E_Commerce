package com.shop.ecommerce.controller;

import com.shop.ecommerce.entity.Product;
import com.shop.ecommerce.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductService productService;

    // 定义了get的call
    @RequestMapping(value = "/listproduct", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listProduct(@Param("productCondition") Product productCondition, @Param("rowIndex") int beginIndex,
                                            @Param("pageSize") int pageSize) {
        // @Param("productCondition") Product productCondition 这是个product entity
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Product> list = new ArrayList<>();
        try {
            list = productService.queryProductList(productCondition,beginIndex,pageSize);
            modelMap.put("data", list);
            // user这样能知道有exception
            modelMap.put("total", list.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }

    @RequestMapping(value = "/productcount", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> queryProductCount(@Param("productCondition") Product productCondition) {
        Map<String, Object> modelMap = new HashMap<>();
        int count = 0;
        try {
            count = productService.queryProductCount(productCondition);
            modelMap.put("data", count);
            // user这样能知道有exception
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }

    @RequestMapping(value = "/productid", method = RequestMethod.GET)
    @ResponseBody
    private Map<Object, Object> queryProductById(long productId) {
        Map<Object, Object> modelMap = new HashMap<>();
        Product product;
        try {
            product = productService.queryProductById(productId);
            modelMap.put(productId, product);
            // user这样能知道有exception
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }

}

