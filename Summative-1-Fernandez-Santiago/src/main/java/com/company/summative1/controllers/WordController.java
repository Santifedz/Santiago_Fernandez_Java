package com.company.summative1.controllers;


import com.company.summative1.models.Definition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/word")
public class WordController {
    List<Definition> words = new ArrayList<>();

    //constructor with data
    public WordController() {

        words.add(new Definition(0, "choice", "an act of selecting or making a decision when faced with two or more possibilities."));
        words.add(new Definition(1, "substitute", "a person or thing acting or serving in place of another."));
        words.add(new Definition(2, "printer", "a person or thing that prints, especially a person whose occupation is printing."));
        words.add(new Definition(3, "reporter", "a person who reports."));
        words.add(new Definition(4, "descent", "the act, process, or fact of moving from a higher to a lower position."));
        words.add(new Definition(5, "function", "the kind of action or activity proper to a person, thing, or institution; the purpose for which something is designed or exists; role."));
        words.add(new Definition(6, "hope", "the feeling that what is wanted can be had or that events will turn out for the best."));
        words.add(new Definition(7, "declaration", "a positive, explicit, or formal statement; proclamation."));
        words.add(new Definition(8, "elbow", "the bend or joint of the human arm between upper arm and forearm."));
        words.add(new Definition(9, "freckle", "any small spot or discoloration."));
    }

    @GetMapping
    public Definition getWordOfTheDay() {
        // Logic to generate and return a random word and its definition
        Random rng = new Random();
        Definition rngElement = words.get(rng.nextInt(words.size()));

        // Replace the following return statement with your actual implementation
        return rngElement;

    }
}
