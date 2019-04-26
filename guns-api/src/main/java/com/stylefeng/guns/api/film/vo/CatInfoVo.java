package com.stylefeng.guns.api.film.vo;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/22.
 */
@Data
public class CatInfoVo implements Serializable {

    private Integer catId;
    private String catName;
    private Boolean isActive;
}
