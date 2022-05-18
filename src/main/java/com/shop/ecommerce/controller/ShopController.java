package com.shop.ecommerce.controller;

import com.shop.ecommerce.entity.Shop;
import com.shop.ecommerce.service.ShopService;

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
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/insertshop", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> insertShop(Shop shop) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result;
        try {
            result = shopService.insertShop(shop);
            modelMap.put("data", result);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }

    @RequestMapping(value = "/updateshop", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> updateShop(Shop shop) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result;
        try {
            result = shopService.updateShop(shop);
            modelMap.put("data", result);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }

    @RequestMapping(value = "/queryshopid", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> queryByShopId(long shopId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Shop result;
        try {
            result = shopService.queryByShopId(shopId);
            modelMap.put("data", result);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }

    @RequestMapping(value = "/queryshoplist", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
                                              @Param("pageSize") int pageSize) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Shop> list = new ArrayList<>();
        try {
            list = shopService.queryShopList(shopCondition, rowIndex, pageSize);
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

    @RequestMapping(value = "/queryshopcount", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> queryShopCount(@Param("shopCondition") Shop shopCondition) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result;
        try {
            result = shopService.queryShopCount(shopCondition);
            modelMap.put("data", result);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }
}
