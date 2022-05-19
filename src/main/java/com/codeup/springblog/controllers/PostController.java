package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.AdsRepository;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;

    public PostController(PostRepository postDao, UserRepository usersDao){
        this.postsDao = postDao;
        this.usersDao = usersDao;
    }




    @GetMapping("/index")
    public String index(Model model){
//        Lecture code for hard-coded posts commented out below:

//        ArrayList<Post> posts = new ArrayList<>();
//        Post post = new Post("Hello World", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
//        Post post2 = new Post("Hello World... again!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
//
//        posts.add(post);
//        posts.add(post2);
//
//        model.addAttribute("posts", posts);


        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/{id}")
    public String postByID(@PathVariable long id, Model model){
//        Post post = new Post("Hello World, Id: " + id, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        Post post = postsDao.getById(id);
        model.addAttribute("post", post);


        return "posts/show";
    }

    @GetMapping("/create")
    public String createForm(){
        return "posts/create";
    }


    @PostMapping("/create")
    public String createPost(
            @RequestParam(name="title") String title,
            @RequestParam(name="body") String body)
    {

        User user = usersDao.findAll().get(0);

        Post post = new Post(title, body, user);
        postsDao.save(post);

        return "redirect:/posts/index";

    }



}
