package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.vo.UserInfo;
import com.stylefeng.guns.api.user.vo.UserModel;
import com.stylefeng.guns.rest.common.CurrentUser;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lwz on 2019/4/18.
 */
@RestController
@RequestMapping(value="/user/")
public class UserController{

    @Reference(interfaceClass = UserAPI.class,check = false)
    private UserAPI userAPI;


    @RequestMapping(value="register")
    public ResponseVO register(UserModel userModel){
        if(StringUtils.isEmpty(userModel.getUsername() )|| StringUtils.isEmpty(userModel.getPassword())){
            return ResponseVO.serviceFail("用戶或者密碼不能為空");

        }


        boolean isSuccess =userAPI.register(userModel);
        if(isSuccess){
            return ResponseVO.success("註冊成功");
        }else {
            return ResponseVO.serviceFail("註冊失敗");
        }
    }
    @RequestMapping(value="getUserInfo",method = RequestMethod.POST)
    public ResponseVO<UserInfo> getUserInfo(){
        String userId = CurrentUser.getCurrentUser();
        if(!StringUtils.isEmpty(userId)){
            UserInfo userInfo = userAPI.getUserInfo(Integer.valueOf(userId));
            if(userInfo !=null){
                return ResponseVO.success(userInfo);
            }else{
                return ResponseVO.serviceFail("查詢失敗");
            }

        }else{
            return ResponseVO.serviceFail("用戶未登錄");
        }
    }

    @RequestMapping(value = "check",method = RequestMethod.POST)
    public ResponseVO check(UserInfo userModel){
        boolean result = userAPI.checkUserName(userModel.getUsername());
            if(result){
               return  ResponseVO.success("驗證成功");
            }else{
                return ResponseVO.serviceFail("用戶已存在");
            }



    }
}
