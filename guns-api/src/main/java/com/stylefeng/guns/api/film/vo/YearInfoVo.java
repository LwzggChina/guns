package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/22.
 */
@Data
public class YearInfoVo implements Serializable{
    private Integer yearId;

    private String yearName;

    private Boolean isActive;

}
