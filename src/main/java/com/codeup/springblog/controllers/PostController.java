package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/posts")
public class PostController {


    @GetMapping()
    public String index(Model model){
        ArrayList<Post> posts = new ArrayList<>();
        Post post = new Post("Hello World", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        Post post2 = new Post("Hello World... again!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        posts.add(post);
        posts.add(post2);

        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/{id}")
    public String postByID(@PathVariable int id, Model model){
        Post post = new Post("Hello World, Id: " + id, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        model.addAttribute("post", post);
        model.addAttribute("id", id);

        return "posts/show";
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
