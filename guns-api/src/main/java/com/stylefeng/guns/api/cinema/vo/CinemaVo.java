package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/25.
 */
@Data
public class CinemaVo implements Serializable {

    private Integer uuid;

    private String cinemaName;

    private String address;

    private String minimumPrice;
}
