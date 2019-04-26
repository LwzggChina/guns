package com.stylefeng.guns.rest.modular.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.cinema.CinemaAPI;
import com.stylefeng.guns.api.cinema.CinemaRqVo;
import com.stylefeng.guns.api.cinema.ConditionRqVo;
import com.stylefeng.guns.api.cinema.vo.*;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lwz on 2019/4/25.
 */
@RestController
@RequestMapping("/cinema/")
public class CinemaController {

    @Reference(interfaceClass = CinemaAPI.class)
    CinemaAPI cinemaAPI;

    @RequestMapping("getcinemas")
    public ResponseVO getCinemas(CinemaRqVo cinemaRqVo){
        Page<CinemaVo> page = cinemaAPI.getCinemas(cinemaRqVo);
        if(page.getRecords() == null || page.getRecords().size()==0){
            return ResponseVO.serviceFail("影院信息查询失败");
        }

        return ResponseVO.success(page.getRecords(),"",page.getCurrent()+"",page.getTotal()+"");

    }

    @RequestMapping("getCondition")
    public ResponseVO getCondition(ConditionRqVo conditionRqVo){
        ConditionVO conditionVO = new ConditionVO();



        conditionVO.setAreaList(cinemaAPI.getAreaList(conditionRqVo.getAreaId()));
        conditionVO.setGetBrandList(cinemaAPI.getBrandList(conditionRqVo.getBrandId()));
        conditionVO.setHalltypeList(cinemaAPI.getHalltypeList(conditionRqVo.getHallType()));

        return ResponseVO.success(conditionVO);

    }

    @RequestMapping(value = "getFields")
    public  ResponseVO getFields(String cinemaId){
        CinemaInfoVO cinemaInfoVO = cinemaAPI.getCinemaById(cinemaId);

        List<FilmInFoVO> filmInFoVOs = cinemaAPI.getFilmInFoVOs(cinemaId);

        FieldsVO fieldsVO =new FieldsVO();
        fieldsVO.setCinemaInfo(cinemaInfoVO);
        fieldsVO.setFilmList(filmInFoVOs);


        return ResponseVO.success(fieldsVO);
    };

    @RequestMapping("getFieldInfo")
    public  ResponseVO getFieldInfo(String cinemaId,String fieldId){

        CinemaInfoVO cinemaInfoVO = cinemaAPI.getCinemaById(cinemaId);
        FilmInFoVO filmInFoVO = cinemaAPI.getFilmInfoById(fieldId);
        HallInfoVo hallInfo = cinemaAPI.getHallInfo(fieldId);
        CinemaFieldResponseVO cinemaFieldResponseVO = new CinemaFieldResponseVO();
        cinemaFieldResponseVO.setCinemaInfoVO(cinemaInfoVO);
        cinemaFieldResponseVO.setFilmInFoVO(filmInFoVO);
        cinemaFieldResponseVO.setHallInfo(hallInfo);

        return ResponseVO.success(cinemaFieldResponseVO);

    }
}
