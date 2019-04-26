package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/26.
 */
@Data
public class FileldsResponeVO implements Serializable {
    private  String fieldId;

    private String beginTime;

    private String endTime;

    private String language;

    private String hallName;

    private  String price;


}
