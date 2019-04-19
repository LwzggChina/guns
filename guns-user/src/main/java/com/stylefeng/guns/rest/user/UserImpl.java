package com.stylefeng.guns.rest.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.UserAPI;
import com.stylefeng.guns.api.UserInfo;
import com.stylefeng.guns.api.UserModel;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.persistence.dao.MoocUserTMapper;
import com.stylefeng.guns.rest.persistence.model.MoocUserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lwz on 2019/4/17.
 */
@Component
@Service(interfaceClass = UserAPI.class)
public class UserImpl implements UserAPI{

    @Autowired
    MoocUserTMapper moocUserTMapper;

    @Override
    public int isLogon(String username, String password) {
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(username);
        //moocUserT.setUserPwd(password);
        MoocUserT result = moocUserTMapper.selectOne(moocUserT);
        if(result != null){
            return result.getUuid();
        }
        return 0;


    }

    @Override
    public boolean register(UserModel userModel) {
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(userModel.getUsername());
        moocUserT.setUserPwd(MD5Util.encrypt(userModel.getPassword()));
        moocUserT.setAddress(userModel.getAddress());
        moocUserT.setEmail(userModel.getEmail());
        moocUserT.setUserPhone(userModel.getPhone());
        Integer count = moocUserTMapper.insert(moocUserT);
        if(count != null && count > 0){
            return true;
        }
            return false;
  }

    @Override
    public boolean checkUserName(String userName) {
        EntityWrapper entityWrapper =new EntityWrapper();
        entityWrapper.eq("user_name",userName);
        int count =moocUserTMapper.selectCount(entityWrapper);
        if(count == 1){
            return false;
        }
            return true;
    }

    @Override
    public UserInfo getUserInfo(int uuid) {
        MoocUserT moocUserT =new MoocUserT();
        moocUserT.setUuid(uuid);
        MoocUserT result =moocUserTMapper.selectOne(moocUserT);
        UserInfo userInfo=do2UserInfo(result);
        return userInfo;
    }

    private UserInfo do2UserInfo(MoocUserT moocUserT){
        UserInfo userInfoModel = new UserInfo();

        userInfoModel.setUuid(moocUserT.getUuid());
        userInfoModel.setHeadAddress(moocUserT.getHeadUrl());
        userInfoModel.setPhone(moocUserT.getUserPhone());

        userInfoModel.setEmail(moocUserT.getEmail());
        userInfoModel.setUsername(moocUserT.getUserName());
        userInfoModel.setNickname(moocUserT.getNickName());

        userInfoModel.setBirthday(moocUserT.getBirthday());
        userInfoModel.setAddress(moocUserT.getAddress());

        userInfoModel.setBeginTime(moocUserT.getBeginTime().getTime());


        return userInfoModel;
    }


}