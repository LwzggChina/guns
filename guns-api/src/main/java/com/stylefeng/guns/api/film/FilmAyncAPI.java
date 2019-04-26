package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.vo.ActorVO;
import com.stylefeng.guns.api.film.vo.FilmDescVo;
import com.stylefeng.guns.api.film.vo.ImgVo;

import java.util.List;

/**
 * Created by lwz on 2019/4/23.
 */

public interface FilmAyncAPI {

    //获取影片描述
    public FilmDescVo getFilmDesc(String filmId);
    //获取图片信息
    public ImgVo getImgs(String filmId);
    //获取导演信息
    public ActorVO getDirector(String filmId);
    //获取演员信息
    public List<ActorVO> getActors(String filmId);


}
