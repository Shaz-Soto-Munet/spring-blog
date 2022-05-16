package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/roll-dice")
public class RollDiceController {

    @GetMapping
    public String rollDice(){
        return "views-lecture/roll-dice";
    }

    @GetMapping("/{num}")
    public String rollDice(@PathVariable int num, Model model){

        Random random = new Random();
        int int_Random = random.nextInt(7);
        boolean userGuess = int_Random == num;

        model.addAttribute("userGuess", userGuess);

        return "views-lecture/roll-dice";
    }

}
