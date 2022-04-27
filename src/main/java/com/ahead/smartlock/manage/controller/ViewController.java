package com.ahead.smartlock.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zqh
 **/
@Controller
public class ViewController {

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
}
