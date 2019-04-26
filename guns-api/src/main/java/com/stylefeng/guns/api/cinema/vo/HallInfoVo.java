package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/26.
 */
@Data
public class HallInfoVo implements Serializable {
    private  String     hallFieldId;
    private  String         hallName;
    private  String        price;
    private  String       seatFile;
    // 已售座位必须关联订单才能查询
    private String soldSeats;

}
