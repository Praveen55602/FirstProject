package com.first.springboot.FirstProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.first.springboot.FirstProject.Dao.AlienRepo;
import com.first.springboot.FirstProject.Model.Alien;

@Controller
@RequestMapping("/aliens") // all the url paths starting with /home will be redirected to this controller
public class AlienController {
    @Autowired
    AlienRepo repo;

    @RequestMapping("") // "/aliens" will be redirected here
    public String AlienHome() {
        return "alien";
    }

    @RequestMapping("/add")
    public String addAlien(Alien alien) {
        repo.save(alien);
        return "alien";
    }

    @RequestMapping("/getalien")
    public ModelAndView getAlien(@RequestParam(name = "aid") Integer aid) {
        Alien res = repo.findById(aid).orElse(new Alien());
        ModelAndView mv = new ModelAndView("showAlien");
        mv.addObject("obj", res);
        return mv;
    }

    // there is no UI for update and delete just pass everything as request params
    @RequestMapping("/updatealien")
    public ModelAndView updateAlien(Alien alien) {
        Alien res = repo.findById(alien.aid).orElse(null);
        if (res != null) {
            res.aid = alien.aid;
            res.lang = alien.lang;
            res.alienName = alien.alienName;
            repo.save(res);
        }
        ModelAndView mv = new ModelAndView("showAlien");
        mv.addObject("obj", res);
        return mv;
    }

    @RequestMapping("/deletealien")
    public String removeAlien(@RequestParam(name = "aid") Integer aid) {
        repo.deleteById(aid);
        return "alien";
    }

}
