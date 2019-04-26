package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lwz on 2019/4/23.
 */
@Data
public class ActorRqVo implements Serializable {

    private ActorVO director;

    private List<ActorVO> actors;

}
