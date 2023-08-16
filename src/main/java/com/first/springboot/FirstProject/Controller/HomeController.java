package com.first.springboot.FirstProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.first.springboot.FirstProject.Model.Alien;

@Controller // adding this tell springboot that this file should be used as controller
public class HomeController {

    // @RequestMapping("home")
    // public String Home() {
    // return "home";
    // }

    @RequestMapping("home")
    // by default you'll not pass any request param in url it will throw error.
    // required = false will make it optional which it should be
    // we also have another thing called defaultValue in place of required
    public ModelAndView Home(@RequestParam(name = "username", required = false) String username) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.addObject("username", username);
        return mv;
    }

    @RequestMapping("home/alien_data")
    public ModelAndView AlienDataExample(Alien alien) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alien");
        mv.addObject("obj", alien);
        return mv;
    }

}
