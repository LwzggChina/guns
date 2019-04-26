package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lwz on 2019/4/22.
 */
@Data
public class ConditionListVo  implements Serializable{

    private List<CatInfoVo> catInfoVos;

    private List<YearInfoVo> yearInfoVos;

    private List<SourceInfoVo> sourceInfoVos;


}
