package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/19.
 */
@Data
public class FilmInfo implements Serializable{

    private String filmId;
    private String filmName;
    private String imgAddress;
    private Integer expectNum;
    private String showTime;
    private String filmScore;
    private Integer filmType;
    private Integer boxNum;
    private String score;
}
