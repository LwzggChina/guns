package com.stylefeng.guns.rest.modular.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.stylefeng.guns.api.film.FilmApi;
import com.stylefeng.guns.api.film.FilmAyncAPI;
import com.stylefeng.guns.api.film.vo.*;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.rest.modular.film.vo.FilmIndexVo;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * Created by lwz on 2019/4/22.
 */
@RestController
@RequestMapping(value="/film/")
public class FilmController {

    @Reference(interfaceClass = FilmApi.class,check = false)
    FilmApi filmApi;
    @Reference(interfaceClass = FilmAyncAPI.class,check = false,async = true)
    FilmAyncAPI filmAyncAPI;

    @RequestMapping(value="index")
    public ResponseVO getIndex(){
        FilmIndexVo filmIndexVo = new FilmIndexVo();

        filmIndexVo.setBanners(filmApi.getBanners());

        filmIndexVo.setHotFilms(filmApi.getHotFilms(true,8));

        filmIndexVo.setSoonFilms(filmApi.getSoonFilms(true,8));

        filmIndexVo.setBoxRanking(filmApi.getBoxRanking(true,8));

        filmIndexVo.setExpectRanking(filmApi.getExpectRanking(true,8));

        filmIndexVo.setTop100(filmApi.getTop100(true,8));

         return ResponseVO.success(filmIndexVo,"");


    }

    @RequestMapping(value="getConditionList")
    public ResponseVO getConditionList(
            @RequestParam(name="catId",required = false)  String catId,
            @RequestParam(name="sourceId",required = false)  String sourceId,
            @RequestParam(name="yearId",required = false)  String yearId
    ){

        return null;
    }
    @RequestMapping(value="getFilms")
    public ResponseVO getFilms(FilmRequestVo filmRequestVo){
               String imgPre="http://img.meetingshop.cn/";
               Integer showType =filmRequestVo.getShowType();
                FilmVo filmVo = null;
               switch (showType){
                   case 1:
                       filmVo=filmApi.getHotFilms(false,filmRequestVo.getPageSize(),filmRequestVo.getCatId(),filmRequestVo.getSourceId(),
                         filmRequestVo.getYearId(),filmRequestVo.getNowPage(),filmRequestVo.getSortId());
                       break;
                   case 2:
                       filmVo=filmApi.getSoonFilms(false,filmRequestVo.getPageSize(),filmRequestVo.getCatId(),filmRequestVo.getSourceId(),
                               filmRequestVo.getYearId(),filmRequestVo.getNowPage(),filmRequestVo.getSortId());
                        break;
                   case 3:
                       filmVo=filmVo=filmApi.getClassicFilms(false,filmRequestVo.getPageSize(),filmRequestVo.getCatId(),filmRequestVo.getSourceId(),
                               filmRequestVo.getYearId(),filmRequestVo.getNowPage(),filmRequestVo.getSortId());
                       break;
                   default:
                       filmVo=filmApi.getHotFilms(false,filmRequestVo.getPageSize(),filmRequestVo.getCatId(),filmRequestVo.getSourceId(),
                               filmRequestVo.getYearId(),filmRequestVo.getNowPage(),filmRequestVo.getSortId());
                       break;
               }

                return ResponseVO.success(filmVo,imgPre,filmVo.getNowPage(),filmVo.getTotalPage());
    }

    @RequestMapping(value="films/{searchFilmId}")
    public ResponseVO getFilmsDetail(@PathVariable("searchFilmId") String searchFilmId,String searchType) throws ExecutionException, InterruptedException {
        FilmDetailVO filmDetailVO = filmApi.getfilmsDetail(searchFilmId, searchType);
        String imgPre="http://img.meetingshop.cn/";
        if(filmDetailVO == null){
            return ResponseVO.serviceFail("查询失败，无影片可加载");
        }

        //dubbo异步调用
        //获取描述
        filmAyncAPI.getFilmDesc(searchFilmId);
        Future<FilmDescVo> filmDescFuture = RpcContext.getContext().getFuture();

        //获取图片
        filmAyncAPI.getImgs(searchFilmId);
        Future<ImgVo> imgFuture= RpcContext.getContext().getFuture();

        //获取导演信息
        filmAyncAPI.getDirector(searchFilmId);
        Future<ActorVO> diretorFuture = RpcContext.getContext().getFuture();

        //获取演员信息
        filmAyncAPI.getActors(searchFilmId);
        Future<List<ActorVO>> actorsFuture = RpcContext.getContext().getFuture();



        //组织
        ActorRqVo actorRqVo =new ActorRqVo();
        actorRqVo.setActors(actorsFuture.get());
        actorRqVo.setDirector(diretorFuture.get());

        Info04Vo info04Vo =new Info04Vo();
        info04Vo.setActors(actorRqVo);
        info04Vo.setBiography(filmDescFuture.get().getBiography());
        info04Vo.setFilmId(filmDescFuture.get().getFilmId());
        info04Vo.setImgs(imgFuture.get());

        filmDetailVO.setInfo04(info04Vo);

        return ResponseVO.success(filmDetailVO,imgPre);
    }
}

