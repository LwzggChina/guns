package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/22.
 */
@Data
public class SourceInfoVo implements Serializable {

    private  Integer sourceId;

    private  String sourceName;

    private Boolean isActive;
}
