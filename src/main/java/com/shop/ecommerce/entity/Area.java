package com.shop.ecommerce.entity;
// entity里只包含该object的参数以及get和set的方法
// 这里get set用lombok实现了

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Area {
    private Long areaId;
    private String areaName;
    private int priority;
    private Date timeCreated;
    private Date timeUpdated;

}
