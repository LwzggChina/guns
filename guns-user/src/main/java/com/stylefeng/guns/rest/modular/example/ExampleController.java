package com.stylefeng.guns.rest.modular.example;

import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 常规控制器
 *
 * @author fengshuonan
 * @date 2017-08-23 16:02
 */
@Controller
@RequestMapping("/hello")
public class ExampleController {

    @RequestMapping("")
    @ResponseBody
    public ResponseVO hello() {



        return ResponseVO.success("请求成功");
    }
}
