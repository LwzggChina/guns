package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.api.film.vo.FilmDetailVO;
import com.stylefeng.guns.rest.persistence.model.MoocFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author lwz
 * @since 2019-04-22
 */
public interface MoocFilmTMapper extends BaseMapper<MoocFilmT> {

    public FilmDetailVO getFilmDetailsById(@Param("filmId") String filmId);

    public FilmDetailVO getFilmDetailsByName(@Param("filmName") String filmName);

}
