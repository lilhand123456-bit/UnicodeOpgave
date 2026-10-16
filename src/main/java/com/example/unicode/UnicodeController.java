package com.example.unicode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnicodeController {

    private final UnicodeRepository repository;

    public UnicodeController(UnicodeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i) {
        char c = (char) i;
        return "unicode=" + i + " char=" + c;
    }

    @GetMapping("/char/{c}")
    public String charToUnicode(@PathVariable char c) {
        return "char=" + c + " unicode=" + (int) c;
    }

    @GetMapping("/chars")
    public String nextChars(@RequestParam char start, @RequestParam int count) {
        int from = start;
        int to = start + count - 1;
        StringBuilder sb = new StringBuilder();
        for (Unicode u : repository.findByUnicodeBetweenOrderByUnicode(from, to)) {
            sb.append(u.getSymbol());
        }
        return sb.toString();
    }
}