package com.example.unicode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Component
public class InitData implements CommandLineRunner {

    private final UnicodeRepository repository;

    public InitData(UnicodeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() > 0) return; // undgå dubletter ved genstart

        Set<Character> letters = new LinkedHashSet<>();
        for (int i = 0; i <= 1000; i++) {
            char c = (char) i;
            if (Character.isLetter(c)) {
                letters.add(c);
            }
        }

        List<Unicode> entities = new ArrayList<>();
        for (char c : letters) {
            entities.add(new Unicode(c, c, ""));
        }
        repository.saveAll(entities);
    }
}