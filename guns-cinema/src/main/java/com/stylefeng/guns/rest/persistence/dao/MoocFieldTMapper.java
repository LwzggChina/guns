package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.api.cinema.vo.FilmInFoVO;
import com.stylefeng.guns.api.cinema.vo.HallInfoVo;
import com.stylefeng.guns.rest.persistence.model.MoocFieldT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-25
 */
public interface MoocFieldTMapper extends BaseMapper<MoocFieldT> {

    //查詢影廳信息
    public HallInfoVo getHallInfo(@Param("fieldId") String fieldId);

    //查詢場次
    public List<FilmInFoVO> getFilmInFoVOs(@Param("cinemaId") String cinemaId);


    public FilmInFoVO getFilmInfoById(@Param("fieldId") String fieldId);




}
