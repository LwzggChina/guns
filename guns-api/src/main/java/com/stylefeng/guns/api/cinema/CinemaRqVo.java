package com.stylefeng.guns.api.cinema;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/25.
 */
@Data
public class CinemaRqVo implements Serializable {
    private Integer brandId=99;

    private Integer hallType=99;

    private Integer districtId=99;

    private Integer pageSize=12;

    private Integer nowPage=1;


}
