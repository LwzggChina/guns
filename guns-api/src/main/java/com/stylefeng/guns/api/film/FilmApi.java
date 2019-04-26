package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.vo.*;

import java.util.List;

/**
 * Created by lwz on 2019/4/22.
 */
public interface FilmApi {
    //获取banners
    public List<BannerVO> getBanners();

    //获取hotFilms
    public FilmVo getHotFilms(boolean Limit, int nums,int catId,int sourceId,int yearId,int nowPage,int sortId);

    public FilmVo getHotFilms(boolean Limit, int nums);
    //获取 新片
    public FilmVo getSoonFilms(boolean Limit,int nums);

    public FilmVo getSoonFilms(boolean Limit, int nums,int catId,int sourceId,int yearId,int nowPage,int sortId);

    //获取经典影片

    public FilmVo getClassicFilms(boolean Limit, int nums,int catId,int sourceId,int yearId,int nowPage,int sortId);

    //获取 boxRanking
    public List<FilmInfo> getBoxRanking(boolean Limit,int nums);



    //获取 expectRanking
    public List<FilmInfo> getExpectRanking(boolean Limit,int nums);


    //获取top100

    public List<FilmInfo> getTop100(boolean Limit,int nums);


    public List<CatInfoVo> getCatInfo(String catId);

    public List<SourceInfoVo> getSourceInfo(String sourceId);

    public List<YearInfoVo> getYearInfo(String yearId);

    public FilmDetailVO getfilmsDetail(String filmId,String searchType);






}
