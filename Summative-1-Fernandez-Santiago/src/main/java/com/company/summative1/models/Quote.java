package com.company.summative1.models;

import java.util.Objects;

public class Quote {
    private int id;
    private String author;
    private String quote;

    public Quote(){}

    public Quote(int id, String author, String quote) {
        this.id = id;
        this.author = author;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Quote otherQuo = (Quote) other;
        return id == otherQuo.id && Objects.equals(this.author, otherQuo.author) && Objects.equals(this.quote, otherQuo.quote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.author, this.quote);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", author='" + this.author + '\'' +
                ", quote='" + this.quote + '\'' +
                '}';
    }

}
