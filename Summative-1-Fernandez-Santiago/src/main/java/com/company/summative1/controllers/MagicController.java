package com.company.summative1.controllers;

import com.company.summative1.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class MagicController {
    private List<String> AnswerPrompts = new ArrayList<>();
    private static int currId = 0;

    //Controller response prompt data
    public MagicController(){
        AnswerPrompts.add("Yes");
        AnswerPrompts.add("Maybe?");
        AnswerPrompts.add("NO!!!");
        AnswerPrompts.add("I don't think so...");
        AnswerPrompts.add("Sure, why not");
        AnswerPrompts.add("umm... probably");
        AnswerPrompts.add("No clue!");
        AnswerPrompts.add("You better not");
        AnswerPrompts.add("Hard no.");
        AnswerPrompts.add("Go ahead!");
        AnswerPrompts.add("You do you :)");
        AnswerPrompts.add("DO IT!");
    }

    /*
    The Magic 8 Ball API provides a magic '8 ball' service
    URI: /magic
    Method: POST
    Request Body: Question (Answer Module)
    Response Body: Answer (Answer Module)
    The POST request for the Magic 8 Ball endpoint should include a user-provided question.

    NOTE: Typically we would add validation to ensure a valid request.
     */
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer getRandomAnswer (@RequestBody @Valid Answer Question){
        // Get a random index from the answer prompts list
        Random random = new Random();
        int index = random.nextInt(AnswerPrompts.size());

        // Assign a unique ID to the question
        Question.setId(currId++);

        // Set the answer of the question
        Question.setAnswer(AnswerPrompts.get(index));

        return Question;
    }

}
