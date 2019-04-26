package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/26.
 */
@Data
public class CinemaFieldResponseVO implements Serializable {
    private HallInfoVo hallInfo;

    private CinemaInfoVO cinemaInfoVO;

    private FilmInFoVO filmInFoVO;
}
