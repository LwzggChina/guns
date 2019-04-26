package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lwz on 2019/4/26.
 */
@Data
public class FilmInFoVO implements Serializable {

    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmType;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private List<FileldsResponeVO> filmFields;

}
