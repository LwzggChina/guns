package com.stylefeng.guns.rest.modular.film.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.film.FilmApi;
import com.stylefeng.guns.api.film.vo.*;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.rest.persistence.dao.*;
import com.stylefeng.guns.rest.persistence.model.MoocBannerT;
import com.stylefeng.guns.rest.persistence.model.MoocCatDictT;
import com.stylefeng.guns.rest.persistence.model.MoocFilmInfoT;
import com.stylefeng.guns.rest.persistence.model.MoocFilmT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwz on 2019/4/22.
 */
@Component
@Service(interfaceClass = FilmApi.class)
public class FilmServiceImpl implements FilmApi
{

    @Autowired
    MoocBannerTMapper moocBannerTMapper;
    @Autowired
    MoocFilmTMapper moocFilmTMapper;

    @Autowired
    MoocCatDictTMapper moocCatDictTMapper;
    @Autowired
    MoocSourceDictTMapper moocSourceDictTMapper;
    @Autowired
    MoocYearDictTMapper moocYearDictTMapper;




    @Override
    public List<BannerVO> getBanners() {
        List<MoocBannerT> moocBannerTS = moocBannerTMapper.selectList(null);
        List<BannerVO> bannerVOS = new ArrayList<BannerVO>();
        for(MoocBannerT m:moocBannerTS){
            BannerVO bannerVO = new BannerVO();
            bannerVO.setBannerAddress(m.getBannerAddress());
            bannerVO.setBannerId(m.getUuid());
            bannerVO.setBannerUrl(m.getBannerUrl());
            bannerVOS.add(bannerVO);


        }
         return bannerVOS;
    }

    @Override
    public FilmVo getHotFilms(boolean Limit, int nums,int catId,int sourceId,int yearId,int nowPage,int sortId) {
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status",1);
        FilmVo filmVo = new FilmVo();
        Page<MoocFilmT> page =null;
        //判断是否是首页数据
        if(Limit){
            page  =new Page(1,nums);
            List<MoocFilmT> moocFilmTS = moocFilmTMapper.selectPage(page, entityWrapper);
            List<FilmInfo> filmInfos = getFilmInfos(moocFilmTS);
            filmVo.setFilmNum(filmInfos.size());
            filmVo.setFilmInfo(filmInfos);
            return  filmVo;

        }else{
            switch (sortId){
                case 1:
                    page = new Page<>(nowPage,nums,"film_box_office");
                    break;
                case 2:
                    page = new Page<>(nowPage,nums,"film_time");
                    break;
                case 3:
                    page = new Page<>(nowPage,nums,"film_score");
                    break;
                default:
                    page = new Page<>(nowPage,nums,"film_box_office");
                    break;
            }
            if(catId !=99){
                String catStr="%#"+catId+"%#";
                entityWrapper.eq("film_cats",catStr);
            }
            if(sourceId !=99){
                entityWrapper.eq("film_source",sourceId);
            }
            if(yearId !=99){
                entityWrapper.eq("film_date",yearId);
            }
            List<MoocFilmT> moocFilmTS = moocFilmTMapper.selectPage(page, entityWrapper);
            List<FilmInfo> filmInfos = getFilmInfos(moocFilmTS);
            filmVo.setFilmNum(filmInfos.size());
            filmVo.setFilmInfo(filmInfos);
            return  filmVo;


        }


    }

    @Override
    public FilmVo getHotFilms(boolean Limit, int nums) {
        return null;
    }

    @Override
    public FilmVo getSoonFilms(boolean Limit, int nums) {
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status",2);
        FilmVo filmVo = new FilmVo();
        //判断是否是首页数据
        if(Limit){
            Page<MoocFilmT> page  =new Page(1,nums);
            List<MoocFilmT> moocFilmTS = moocFilmTMapper.selectPage(page, entityWrapper);
            List<FilmInfo> filmInfos = getFilmInfos(moocFilmTS);
            filmVo.setFilmNum(filmInfos.size());
            filmVo.setFilmInfo(filmInfos);
            return  filmVo;

        }else{


        }

        return null;
    }

    @Override
    public FilmVo getSoonFilms(boolean Limit, int nums, int catId, int sourceId, int yearId, int nowPage, int sortId){
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status",2);
        FilmVo filmVo = new FilmVo();
        Page<MoocFilmT> page =null;
        //判断是否是首页数据
        if(Limit){
            page  =new Page(1,nums);
            List<MoocFilmT> moocFilmTS = moocFilmTMapper.selectPage(page, entityWrapper);
            List<FilmInfo> filmInfos = getFilmInfos(moocFilmTS);
            filmVo.setFilmNum(filmInfos.size());
            filmVo.setFilmInfo(filmInfos);
            return  filmVo;

        }else{
            switch (sortId){
                case 1:
                    page = new Page<>(nowPage,nums,"film_box_office");
                    break;
                case 2:
                    page = new Page<>(nowPage,nums,"film_time");
                    break;
                case 3:
                    page = new Page<>(nowPage,nums,"film_score");
                    break;
                default:
                    page = new Page<>(nowPage,nums,"film_box_office");
                    break;
            }
            if(catId !=99){
                String catStr="%#"+catId+"%#";
                entityWrapper.eq("film_cats",catStr);
            }
            if(sourceId !=99){
                entityWrapper.eq("film_source",sourceId);
            }
            if(yearId !=99){
                entityWrapper.eq("film_date",yearId);
            }
            List<MoocFilmT> moocFilmTS = moocFilmTMapper.selectPage(page, entityWrapper);
            List<FilmInfo> filmInfos = getFilmInfos(moocFilmTS);
            filmVo.setFilmNum(filmInfos.size());
            filmVo.setFilmInfo(filmInfos);
            return  filmVo;


        }


    }

    @Override
    public FilmVo getClassicFilms(boolean Limit, int nums, int catId, int sourceId, int yearId, int nowPage, int sortId) {
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status",3);
        FilmVo filmVo = new FilmVo();
        Page<MoocFilmT> page =null;
        //判断是否是首页数据
        if(Limit){
            page  =new Page(1,nums);
            List<MoocFilmT> moocFilmTS = moocFilmTMapper.selectPage(page, entityWrapper);
            List<FilmInfo> filmInfos = getFilmInfos(moocFilmTS);
            filmVo.setFilmNum(filmInfos.size());
            filmVo.setFilmInfo(filmInfos);
            return  filmVo;

        }else{
            switch (sortId){
                case 1:
                    page = new Page<>(nowPage,nums,"film_box_office");
                    break;
                case 2:
                    page = new Page<>(nowPage,nums,"film_time");
                    break;
                case 3:
                    page = new Page<>(nowPage,nums,"film_score");
                    break;
                default:
                    page = new Page<>(nowPage,nums,"film_box_office");
                    break;
            }
            if(catId !=99){
                String catStr="%#"+catId+"%#";
                entityWrapper.eq("film_cats",catStr);
            }
            if(sourceId !=99){
                entityWrapper.eq("film_source",sourceId);
            }
            if(yearId !=99){
                entityWrapper.eq("film_date",yearId);
            }
            List<MoocFilmT> moocFilmTS = moocFilmTMapper.selectPage(page, entityWrapper);
            List<FilmInfo> filmInfos = getFilmInfos(moocFilmTS);
            filmVo.setFilmNum(filmInfos.size());
            filmVo.setFilmInfo(filmInfos);
            return  filmVo;


        }


    }


    @Override
    public List<FilmInfo> getBoxRanking(boolean Limit, int nums) {
        // 条件 -> 正在上映的，票房前10名
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","1");

        Page<MoocFilmT> page = new Page<>(1,10,"film_box_office");

        List<MoocFilmT> moocFilms = moocFilmTMapper.selectPage(page,entityWrapper);

        List<FilmInfo> filmInfos = getFilmInfos(moocFilms);

        return filmInfos;

    }



    @Override
    public List<FilmInfo> getExpectRanking(boolean Limit, int nums) {
        // 条件 -> 即将上映的，预售前10名
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","2");

        Page<MoocFilmT> page = new Page<>(1,10,"film_preSaleNum");

        List<MoocFilmT> moocFilms = moocFilmTMapper.selectPage(page,entityWrapper);

        List<FilmInfo> filmInfos = getFilmInfos(moocFilms);

        return filmInfos;
    }



    @Override
    public List<FilmInfo> getTop100(boolean Limit, int nums) {
        // 条件 -> 正在上映的，评分前10名
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","1");

        Page<MoocFilmT> page = new Page<>(1,10,"film_score");

        List<MoocFilmT> moocFilms = moocFilmTMapper.selectPage(page,entityWrapper);

        List<FilmInfo> filmInfos = getFilmInfos(moocFilms);

        return filmInfos;
    }

    @Override
    public List<CatInfoVo> getCatInfo(String catId) {
        return null;
    }

    @Override
    public List<SourceInfoVo> getSourceInfo(String sourceId) {
        return null;
    }

    @Override
    public List<YearInfoVo> getYearInfo(String yearId) {
        return null;
    }

    @Override
    public FilmDetailVO getfilmsDetail(String filmId, String searchType) {
        FilmDetailVO filmDetailVO =null; ;
        if(searchType.equals("1")){
            filmDetailVO =moocFilmTMapper.getFilmDetailsByName(filmId);
        }else if(searchType.equals("0")){
            filmDetailVO = moocFilmTMapper.getFilmDetailsById(filmId);
        }

        return filmDetailVO;
    }




    private List<FilmInfo> getFilmInfos(List<MoocFilmT> moocFilms){
        List<FilmInfo> filmInfos = new ArrayList<>();
        for(MoocFilmT moocFilmT : moocFilms){
            FilmInfo filmInfo = new FilmInfo();
            filmInfo.setScore(moocFilmT.getFilmScore());
            filmInfo.setImgAddress(moocFilmT.getImgAddress());
            filmInfo.setFilmType(moocFilmT.getFilmType());
            filmInfo.setFilmScore(moocFilmT.getFilmScore());
            filmInfo.setFilmName(moocFilmT.getFilmName());
            filmInfo.setFilmId(moocFilmT.getUuid()+"");
            filmInfo.setExpectNum(moocFilmT.getFilmPresalenum());
            filmInfo.setBoxNum(moocFilmT.getFilmBoxOffice());
            filmInfo.setShowTime(DateUtil.getDay(moocFilmT.getFilmTime()));

            // 将转换的对象放入结果集
            filmInfos.add(filmInfo);
        }

        return filmInfos;
    }
}
