package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/22.
 */
@Data
public class FilmRequestVo implements Serializable {

    private Integer showType=1;

    private Integer sortId=1;

    private Integer catId=99;

    private Integer sourceId=99;

    private Integer yearId=99;

    private Integer nowPage=1;

    private Integer pageSize=18;
}
