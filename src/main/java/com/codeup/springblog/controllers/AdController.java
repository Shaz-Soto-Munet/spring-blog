package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.AdsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ads")
public class AdController {
    private final AdsRepository adDao;

    public AdController(AdsRepository adDao){
        this.adDao = adDao;
    }

    @GetMapping
    public String allAds(Model model){
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/search")
    public String adSearch(Model model){
        return "ads/search";
    }

    @PostMapping("/search")
    public String searchResults(
            @RequestParam(name="search") long title,
            Model model)
    {
        model.addAttribute("ads", adDao.findById(title));
        return "ads/search";
    }

}
