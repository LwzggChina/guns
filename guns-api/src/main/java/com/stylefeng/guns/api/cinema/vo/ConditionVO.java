package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lwz on 2019/4/25.
 */
@Data
public class ConditionVO implements Serializable{

    private List<BrandVo> getBrandList;

    private List<AreaVo> areaList;

    private List<HalltypeVo> halltypeList;

}
