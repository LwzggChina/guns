package com.stylefeng.guns.api.cinema.vo;

import com.stylefeng.guns.api.film.vo.FilmInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lwz on 2019/4/25.
 */
@Data
public class FieldsVO implements Serializable {
    private CinemaInfoVO cinemaInfo;

    private List<FilmInFoVO> filmList;


}
