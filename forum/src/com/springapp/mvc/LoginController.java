package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by slzZp on 2018/1/30.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/loginCheck.html")
    public String loginPage(){
        return "login";
    }

}
