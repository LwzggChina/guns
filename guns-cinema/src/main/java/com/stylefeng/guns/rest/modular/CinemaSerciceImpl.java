package com.stylefeng.guns.rest.modular;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.cinema.CinemaAPI;
import com.stylefeng.guns.api.cinema.CinemaRqVo;
import com.stylefeng.guns.api.cinema.vo.*;
import com.stylefeng.guns.rest.persistence.dao.*;
import com.stylefeng.guns.rest.persistence.model.MoocAreaDictT;
import com.stylefeng.guns.rest.persistence.model.MoocBrandDictT;
import com.stylefeng.guns.rest.persistence.model.MoocCinemaT;
import com.stylefeng.guns.rest.persistence.model.MoocHallDictT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwz on 2019/4/25.
 */
@Component
@Service(interfaceClass = CinemaAPI.class)
public class CinemaSerciceImpl implements CinemaAPI
{

    @Autowired
    MoocCinemaTMapper moocCinemaTMapper;

    @Autowired
    MoocBrandDictTMapper moocBrandDictTMapper;

    @Autowired
    MoocAreaDictTMapper moocAreaDictTMapper;

    @Autowired
    MoocHallDictTMapper moocHallDictTMapper;

    @Autowired
    MoocFieldTMapper moocFieldTMapper;



    @Override
    public Page<CinemaVo> getCinemas(CinemaRqVo cinemaRqVo) {
        EntityWrapper entityWrapper = new EntityWrapper();
        if(cinemaRqVo.getBrandId() != 99){
            entityWrapper.eq("brand_id" ,cinemaRqVo.getBrandId());
         }
         if(cinemaRqVo.getHallType() != 99){
             entityWrapper.eq("hallType",cinemaRqVo.getHallType());
         }
         if(cinemaRqVo.getDistrictId()!=99){
             entityWrapper.eq("area_id",cinemaRqVo.getDistrictId());
         }


        Page page =new Page<>(cinemaRqVo.getNowPage(),cinemaRqVo.getPageSize());
        List<MoocCinemaT> list = moocCinemaTMapper.selectPage(page, entityWrapper);
        List<CinemaVo> cinemaVos = new ArrayList<CinemaVo>();

        for(MoocCinemaT m :list){
        CinemaVo cinemaVo = new CinemaVo();
        cinemaVo.setUuid(m.getUuid());
        cinemaVo.setAddress(m.getCinemaAddress());
        cinemaVo.setCinemaName(m.getCinemaName());
        cinemaVo.setMinimumPrice(m.getMinimumPrice()+"");
        cinemaVos.add(cinemaVo);

        }

        Page<CinemaVo> pages =new Page<>();
        pages.setRecords(cinemaVos);
        pages.setCurrent(cinemaRqVo.getNowPage());
        pages.setTotal(cinemaVos.size());
        return pages;
    }

    @Override
    public List<BrandVo> getBrandList(int brandId) {
        //判断传入Id是否存在 ，不存在返回全部

        MoocBrandDictT moocBrandDictT = moocBrandDictTMapper.selectById(brandId);
        boolean flag =false;
        if(brandId == 99 || moocBrandDictT ==null){
            flag=true;
        }
        List<MoocBrandDictT> moocBrandDictTS = moocBrandDictTMapper.selectList(null);
        List<BrandVo> brandList = new ArrayList<BrandVo>();
        for(MoocBrandDictT m:moocBrandDictTS){
        BrandVo brandVo = new BrandVo();
        brandVo.setBrandId(m.getUuid());
        brandVo.setBrandName(m.getShowName());
        brandVo.setIsActive(false);
        if(flag) {
            if (m.getUuid() == 99) {
                brandVo.setIsActive(true);
            }
        }else{
                if(m.getUuid() == brandId){
                brandVo.setIsActive(true);
            }


        }

            brandList.add(brandVo);
        }
           return brandList;
    }

    @Override
    public List<AreaVo> getAreaList(int areaId) {
        //判断传入Id是否存在 ，不存在返回全部

        MoocAreaDictT moocAreaDictT = moocAreaDictTMapper.selectById(areaId);
        boolean flag =false;
        if(areaId == 99 || moocAreaDictT ==null){
            flag=true;
        }
        List<MoocAreaDictT> moocAreaDictTS = moocAreaDictTMapper.selectList(null);
        List<AreaVo> areaVos = new ArrayList<AreaVo>();
        for(MoocAreaDictT m:moocAreaDictTS){
            AreaVo areaVo = new AreaVo();
            areaVo.setAreaId(m.getUuid());
            areaVo.setAreaName(m.getShowName());
            areaVo.setIsActive(false);
            if(flag){
                if(m.getUuid()==99){
                    areaVo.setIsActive(true);
                }}
                else{
                    if(m.getUuid() == areaId){
                        areaVo.setIsActive(true);
                    }




            }

            areaVos.add(areaVo);
        }
        return areaVos;







    }

    @Override
    public List<HalltypeVo> getHalltypeList(int hallType) {
        //判断传入Id是否存在 ，不存在返回全部

        MoocHallDictT moocHallDictT = moocHallDictTMapper.selectById(hallType);
        boolean flag =false;
        if(hallType == 99 || moocHallDictT ==null){
            flag=true;
        }
        List<MoocHallDictT> moocHallDictTS = moocHallDictTMapper.selectList(null);
        List<HalltypeVo> halltypeVos = new ArrayList<HalltypeVo>();

        for(MoocHallDictT m:moocHallDictTS){
            HalltypeVo halltypeVo = new HalltypeVo();
            halltypeVo.setHalltypeId(m.getUuid());
            halltypeVo.setHalltypeName(m.getShowName());
            halltypeVo.setIsActive(false);
            if(flag) {
                if (m.getUuid() == 99) {
                    halltypeVo.setIsActive(true);
                }
            }else {

                    if (m.getUuid() == hallType) {
                        halltypeVo.setIsActive(true);
                    }
                }


            halltypeVos.add(halltypeVo);
        }
        return halltypeVos;
    }

    @Override
    public CinemaInfoVO getCinemaById(String cinemaId) {
        MoocCinemaT moocCinemaT = moocCinemaTMapper.selectById(cinemaId);

        CinemaInfoVO cinemaInfoVO =new CinemaInfoVO();
        cinemaInfoVO.setCinemaId(moocCinemaT.getUuid()+"");
        cinemaInfoVO.setCinemaAdress(moocCinemaT.getCinemaAddress());
        cinemaInfoVO.setCinemaName(moocCinemaT.getCinemaName());
        cinemaInfoVO.setCinemaPhone(moocCinemaT.getCinemaPhone());
        cinemaInfoVO.setImgUrl(moocCinemaT.getImgAddress());

         return  cinemaInfoVO;


    }

    @Override
    public List<FilmInFoVO> getFilmInFoVOs(String cinemaId) {
        List<FilmInFoVO> filmInFoVOs = moocFieldTMapper.getFilmInFoVOs(cinemaId);
        return filmInFoVOs;


    }

    @Override
    public FilmInFoVO getFilmInfoById(String fileldId) {
        FilmInFoVO filmInFoVO = moocFieldTMapper.getFilmInfoById(fileldId);
        return filmInFoVO;
    }

    @Override
    public HallInfoVo getHallInfo(String fileldId) {
        HallInfoVo hallInfo = moocFieldTMapper.getHallInfo(fileldId);
        return hallInfo;
    }
}
