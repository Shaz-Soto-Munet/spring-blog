package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {


    @GetMapping()
    @ResponseBody
    public String index(){
        return "This is the posts index page";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String postByID(@PathVariable int id){
        return "This page displays post with id: " + id;
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String createForm(){
        return "This page lets you view the form to create a post.";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(){
        return "This page lets you create a post.";
    }

}
