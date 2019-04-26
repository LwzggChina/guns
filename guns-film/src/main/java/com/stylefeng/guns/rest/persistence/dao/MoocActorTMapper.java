package com.stylefeng.guns.rest.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.api.film.vo.ActorVO;
import com.stylefeng.guns.rest.persistence.model.MoocActorT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author lwz
 * @since 2019-04-22
 */
public interface MoocActorTMapper extends BaseMapper<MoocActorT> {

    public List<ActorVO> getActors(@Param("filmId")String filmId);

}
