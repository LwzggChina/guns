package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lwz on 2019/4/19.
 */
@Data
public class BannerVO implements Serializable {
    private long bannerId;
    private String bannerAddress;
    private String bannerUrl;

}
