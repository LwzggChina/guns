package com.stylefeng.guns.rest.modular.film;

import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lwz on 2019/4/19.
 */

@RequestMapping("/film/")
public class FilmController
{
    @RequestMapping(value = "getIndex",method = RequestMethod.GET)
    public ResponseVO getIndex(){
        //获取商标
        BannerVO bannerVO =new BannerVO();


        return null;

    }
}
