package com.stylefeng.guns.api.cinema;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.cinema.vo.*;

import java.util.List;


/**
 * Created by lwz on 2019/4/25.
 */
public interface CinemaAPI {

    public Page<CinemaVo> getCinemas(CinemaRqVo cinemaRqVo);

    //获取条件查询列表

    public List<BrandVo> getBrandList(int brandId);

    public List<AreaVo> getAreaList(int areaId);

    public List<HalltypeVo> getHalltypeList(int hallType);

    //获取影院信息
    public CinemaInfoVO getCinemaById(String cinemaId);

    //获取该影院的电影以及场次
    public List<FilmInFoVO> getFilmInFoVOs(String cinemaId);

    //通過場次ID查詢電影信息
    public FilmInFoVO getFilmInfoById(String fileldId);

    //查詢影廳信息
    public HallInfoVo getHallInfo(String fileldId);




}
