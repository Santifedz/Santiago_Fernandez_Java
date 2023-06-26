package com.company.chatterbox;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<ChatterPost> chatterPosts;

    public User(){}

    public User(String name){
        this.name = name;
        this.chatterPosts = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public List<ChatterPost> getChatterPosts(){
        return this.chatterPosts;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts){
        this.chatterPosts = chatterPosts;
    }


}
