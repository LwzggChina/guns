package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/25.
 */
@Data
public class HalltypeVo implements Serializable {

    private  Integer halltypeId;

    private  String halltypeName;

    private  Boolean isActive;
}
