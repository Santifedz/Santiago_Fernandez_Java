package com.company.summative1.controllers;

import com.company.summative1.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
public class QuoteController {

    private List<Quote> quotes = new ArrayList<>();

    public QuoteController() {
        quotes.add(new Quote(0,"Kelly Clarkson","What doesn't kill you makes you stronger."));
        quotes.add(new Quote(1,"Eddie Stone","What goes around comes around."));
        quotes.add(new Quote(2,"Percy Green","A man of words and not of deeds is like a garden full of weeds."));
        quotes.add(new Quote(3,"William Christopher Handy","Life is like a trumpet. If you don't put anything into it, you don't get anything out."));
        quotes.add(new Quote(4,"Emily Dickinson","Unable are the loved to die for love is immortality."));
        quotes.add(new Quote(5,"Kobe Bryant","Hard work outweighs talent — every time."));
        quotes.add(new Quote(6,"James Baldwin","All art is a kind of confession."));
        quotes.add(new Quote(7,"Eleanor Roosevelt","If life were predictable it would cease to be life, and be without flavor."));
        quotes.add(new Quote(8,"Babe Ruth","Never let the fear of striking out keep you from playing the game."));
        quotes.add(new Quote(9,"Ayn Rand","The question isn't who is going to let me; it's who is going to stop me."));
    }

    @RequestMapping(value="/quote", method = RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public Quote getQuote() {

        Random random = new Random();
        int idx = random.nextInt(quotes.size());  //randomly picks a quote
        Quote q = quotes.get(idx);

        return q;

    }
}
