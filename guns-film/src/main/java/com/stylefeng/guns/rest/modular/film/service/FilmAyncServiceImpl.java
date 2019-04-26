package com.stylefeng.guns.rest.modular.film.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.film.FilmAyncAPI;
import com.stylefeng.guns.api.film.vo.ActorVO;
import com.stylefeng.guns.api.film.vo.FilmDescVo;
import com.stylefeng.guns.api.film.vo.ImgVo;
import com.stylefeng.guns.rest.persistence.dao.MoocActorTMapper;
import com.stylefeng.guns.rest.persistence.dao.MoocFilmInfoTMapper;
import com.stylefeng.guns.rest.persistence.model.MoocActorT;
import com.stylefeng.guns.rest.persistence.model.MoocFilmInfoT;
import com.stylefeng.guns.rest.persistence.model.MoocYearDictT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lwz on 2019/4/23.
 */
@Component
@Service(interfaceClass = FilmAyncAPI.class)
public class FilmAyncServiceImpl implements FilmAyncAPI
{

    @Autowired
    MoocFilmInfoTMapper moocFilmInfoTMapper;

    @Autowired
    MoocActorTMapper moocActorTMapper;


    public MoocFilmInfoT getFilmInfo(String filmId){
        MoocFilmInfoT moocFilmInfoT = moocFilmInfoTMapper.selectById(filmId);
        return moocFilmInfoT;
    }


    @Override
    public FilmDescVo getFilmDesc(String filmId) {

        MoocFilmInfoT moocFilmInfoT = moocFilmInfoTMapper.selectById(filmId);
        FilmDescVo filmDescVo =new FilmDescVo();
        filmDescVo.setFilmId(filmId);
        filmDescVo.setBiography(moocFilmInfoT.getBiography());
        return filmDescVo;
    }

    @Override
    public ImgVo getImgs(String filmId) {
        MoocFilmInfoT filmInfo = getFilmInfo(filmId);
        String[] imgs =filmInfo.getFilmImgs().split(",");
        ImgVo imgVo = new ImgVo();

        imgVo.setMainImg(imgs[0]);

        imgVo.setImg01(imgs[1]);
        imgVo.setImg02(imgs[2]);


        imgVo.setImg03(imgs[3]);
        imgVo.setImg04(imgs[4]);

        return imgVo;


    }

    @Override
    public ActorVO getDirector(String filmId) {
        MoocFilmInfoT filmInfo = getFilmInfo(filmId);
        MoocActorT moocActorT = moocActorTMapper.selectById(filmId);
        ActorVO actorVO =new ActorVO();
        actorVO.setDirectorName(moocActorT.getActorName());
        actorVO.setImgAddress(moocActorT.getActorImg());
        return actorVO;
    }

    @Override
    public List<ActorVO> getActors(String filmId) {
       List<ActorVO> actors = moocActorTMapper.getActors(filmId);
        return actors;
    }
}
