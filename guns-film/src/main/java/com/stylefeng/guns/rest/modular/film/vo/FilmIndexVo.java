package com.stylefeng.guns.rest.modular.film.vo;

import com.stylefeng.guns.api.film.vo.BannerVO;
import com.stylefeng.guns.api.film.vo.FilmInfo;
import com.stylefeng.guns.api.film.vo.FilmVo;
import lombok.Data;

import java.util.List;

/**
 * Created by lwz on 2019/4/19.
 */
@Data
public class FilmIndexVo{
    private List<BannerVO> banners;
    private FilmVo hotFilms;
    private FilmVo  soonFilms;
    private  List<FilmInfo> boxRanking;
    private List<FilmInfo> expectRanking;
    private List<FilmInfo> top100;

}
