package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/25.
 */
@Data
public class BrandVo implements Serializable
{

    private Integer brandId;

    private String brandName;

    private Boolean isActive;
}
