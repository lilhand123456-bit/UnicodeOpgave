package com.example.unicode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Unicode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int unicode;
    private char symbol;
    private String description;

    public Unicode() {
    }

    public Unicode(int unicode, char symbol, String description) {
        this.unicode = unicode;
        this.symbol = symbol;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getUnicode() { return unicode; }
    public void setUnicode(int unicode) { this.unicode = unicode; }

    public char getSymbol() { return symbol; }
    public void setSymbol(char symbol) { this.symbol = symbol; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
