package com.stylefeng.guns.api.user;

import com.stylefeng.guns.api.user.vo.UserInfo;
import com.stylefeng.guns.api.user.vo.UserModel;

/**
 * Created by lwz on 2019/4/17.
 */
public interface UserAPI {
    int isLogon(String username ,String password);

    boolean register(UserModel userModel);

    boolean checkUserName(String userName);

    UserInfo getUserInfo(int uuid);


}
