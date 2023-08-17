package com.first.springboot.FirstProject.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.first.springboot.FirstProject.Dao.AlienRepo;
import com.first.springboot.FirstProject.Model.Alien;

@RestController
@RequestMapping("/aliens") // all the url paths starting with /home will be redirected to this controller
public class AlienController {
    @Autowired
    AlienRepo repo;

    @GetMapping("") // "/aliens" will be redirected here
    public String AlienHome() {
        return "alien";
    }

    @PostMapping("/add")
    public Alien addAlien(Alien alien) {
        repo.save(alien);
        return alien;
    }

    @GetMapping("/getalien")
    public ModelAndView getAlien(@RequestParam(name = "aid") Integer aid) {
        Alien res = repo.findById(aid).orElse(new Alien());
        ModelAndView mv = new ModelAndView("showAlien");
        mv.addObject("obj", res);
        return mv;
    }

    @GetMapping("/getaliens")
    @ResponseBody // as we are just returning response from this. This tag tell that I'll not go
                  // to any view just return a response
    public List<Alien> getAliens() {// now the all the aliens will be returned and the response will automatically
                                    // get converted to json by spring boot using jackson-core
        return repo.findAll();
    }

    @GetMapping("/getaliens/{aid}")
    @ResponseBody
    // since findbyid may return null that's why here java forces us to return
    // optional
    public Optional<Alien> getAlienById(@PathVariable("aid") int aid) {
        return repo.findById(aid);
    }

    // there is no UI for update and delete just pass everything as request params
    @GetMapping("/updatealien")
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

    @DeleteMapping("/deletealien/{aid}")
    public Alien removeAlien(@PathVariable int aid) {
        Alien a = repo.findById(aid).orElse(new Alien());
        repo.deleteById(aid);
        return a;
    }

    @GetMapping("/getbylang")
    public String getByLang(@RequestParam(name = "lang") String lang) {
        System.out.println(repo.findByLang(lang));
        System.out.println(repo.findByAidGreaterThan(1));
        System.out.println(repo.findByLangSorted("java"));
        return "alien";
    }

}
