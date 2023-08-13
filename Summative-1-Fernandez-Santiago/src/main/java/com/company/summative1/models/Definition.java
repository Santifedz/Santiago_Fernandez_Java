package com.company.summative1.models;

import java.util.Objects;

public class Definition {
    private long id;
    private String word;
    private String definition;

    // constructors, getters, and setters
    public Definition(){}

    public Definition(long id, String word, String definition) {
        this.id = id;
        this.word = word;
        this.definition = definition;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Definition otherDef = (Definition) other;
        return id == otherDef.id && Objects.equals(this.word, otherDef.word) && Objects.equals(this.definition, otherDef.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.word, this.definition);
    }

    @Override
    public String toString() {
        return "Definition{" +
                "id=" + id +
                ", word='" + this.word + '\'' +
                ", definition='" + this.definition + '\'' +
                '}';
    }
}

