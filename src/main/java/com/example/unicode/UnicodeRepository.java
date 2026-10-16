package com.example.unicode;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnicodeRepository extends JpaRepository<Unicode, Long> {

    List<Unicode> findByUnicodeBetweenOrderByUnicode(int from, int to);
}