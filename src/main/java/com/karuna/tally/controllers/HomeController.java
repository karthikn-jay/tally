package com.karuna.tally.controllers;

import com.karuna.tally.model.LoginVO;
import com.karuna.tally.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private static final String LOGIN_PAGE = "loginPage";
    private static final String HOME_PAGE = "homePage";

    @Autowired
    private TransactionsService transactionsService;

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("loginVO", new LoginVO());
        return LOGIN_PAGE;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute LoginVO loginVO, Model model, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) {
        //RedirectView redirectView = null;
        if(loginVO != null) {
            if( loginVO.getUsername().equals("demo") && loginVO.getPassword().equals("partner") ) {
                //redirectView = new RedirectView(HOME_PAGE, true);
                model.addAttribute("username", loginVO.getUsername());
                httpServletRequest.getSession(true).setAttribute("username", loginVO.getUsername());
                httpServletRequest.getSession(true).setAttribute("transactionsVOList", transactionsService.getAllTransactions());
                //redirectView.addStaticAttribute("username", loginVO.getUsername());
                //redirectView.addStaticAttribute("transactionsVOList", transactionsService.getAllTransactions());
                redirectAttributes.addFlashAttribute("username", loginVO.getUsername());
                redirectAttributes.addFlashAttribute("transactionsVOList", transactionsService.getAllTransactions());
                //return "redirect:" + HOME_PAGE;
                //return "/home";
                return new ModelAndView(HOME_PAGE, "username", loginVO.getUsername());
            } else {
                httpServletRequest.setAttribute("errorMsg", "Invalid Username or Password");
                //return LOGIN_PAGE;
                return new ModelAndView(LOGIN_PAGE);
                //redirectView = new RedirectView(LOGIN_PAGE, true);
                //return redirectView;
            }
        }
        //return LOGIN_PAGE;
        return new ModelAndView(LOGIN_PAGE);
        //return redirectView;
    }

    /*@GetMapping("/home")
    public String home(Model model, HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession(true).setAttribute("transactionsVOList", transactionsService.getAllTransactions());
        return HOME_PAGE;
    }*/

}
