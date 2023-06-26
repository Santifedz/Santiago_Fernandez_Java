package com.company.chatterbox;

public class ChatterPost {
    private String text;

    public ChatterPost(){}

    public ChatterPost(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
