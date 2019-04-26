package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lwz on 2019/4/19.
 */
@Data
public class FilmVo implements Serializable {

    private  int    filmNum;
    private List<FilmInfo> filmInfo;
    private String nowPage;
    private String totalPage;


}
