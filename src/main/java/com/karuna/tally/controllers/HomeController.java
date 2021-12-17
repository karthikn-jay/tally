package com.karuna.tally.controllers;

import com.karuna.tally.model.LoginVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private static final String LOGIN_PAGE = "loginPage";
    private static final String HOME_PAGE = "homePage";

    @RequestMapping("/")
    public String login(Model model) {
        model.addAttribute("loginVO", new LoginVO());
        return LOGIN_PAGE;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginVO loginVO, HttpServletRequest httpServletRequest) {
        if(loginVO != null) {
            if( loginVO.getUsername().equals("demo") && loginVO.getPassword().equals("partner") ) {
                httpServletRequest.getSession(true).setAttribute("username", loginVO.getUsername());
                return "redirect:" + HOME_PAGE;
            } else {
                httpServletRequest.setAttribute("errorMsg", "Invalid Username or Password");
                return LOGIN_PAGE;
            }
        }
        return LOGIN_PAGE;
    }

    @RequestMapping("/homePage")
    public String home(Model model) {
        return HOME_PAGE;
    }

}
