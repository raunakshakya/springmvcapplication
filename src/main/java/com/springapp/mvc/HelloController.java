package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    //If URL = /hello , return hello page.
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("title", "Spring Security Hello World");
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    //If URL = /welcome or / , return hello page.
    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        return model;
    }

    //If URL = /admin , return admin page.
    @RequestMapping(value = {"/admin**"}, method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");
        return model;
    }
}