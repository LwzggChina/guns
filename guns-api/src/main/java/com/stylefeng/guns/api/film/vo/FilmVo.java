package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by lwz on 2019/4/19.
 */
@Data
public class FilmVo {

    private  int    filmNum;
    private List<FilmInfo> filmInfo;
}
