package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/23.
 */
@Data
public class Info04Vo implements Serializable {

    private String biography;

    private ActorRqVo actors;

    private ImgVo imgs;

    private String filmId;

}
