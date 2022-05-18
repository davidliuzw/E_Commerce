package com.shop.ecommerce.controller;

import com.shop.ecommerce.entity.Area;
import com.shop.ecommerce.service.AreaService;
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
// 相当于url为/admin/hello这个样子？对
public class AreaController {

    @Autowired
    // 使用areaService这个interface，直接implement了？
        // 就是说areaservice就是AreaService的一个implement？相当于AreaServiceImpl？
    // 也new了一个area object？
    private AreaService areaService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    // 定义了get的call
    @ResponseBody
    private String testHello() {
        return "HelloWorld from spring controller";
    }

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> list = new ArrayList<>();
        try {
            list = areaService.getAreaList();
            // 这个getAreaList方法是AreaServiceImpl里override的那个方法？
            // areaservice就是个interface调这个里面的函数有意义？
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

    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> addArea(Area area) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result;
        try {
            result = areaService.addArea(area);
            // 这个getAreaList方法是AreaServiceImpl里override的那个方法？
            // areaservice就是个interface调这个里面的函数有意义？
            modelMap.put("data", result);
            // user这样能知道有exception
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }
}
