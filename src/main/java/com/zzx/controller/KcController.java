package com.zzx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName KcController
 * @Description
 * @Author zhangzx
 * @Date 2019/7/31 9:41
 * Version 1.0
 **/
@Controller
@RequestMapping("/kc")
public class KcController {

    @GetMapping("/info")
    public ModelAndView list() {
//        System.out.println("康闯，你个比小婊砸，欢迎来到我的电脑");
        return new ModelAndView("kc/kc.html");
    }


}
