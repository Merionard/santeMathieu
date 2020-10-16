package com.entites;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ReleveInformationsTest {

    @Test
    public void dateTest(){
        LocalDateTime now = LocalDateTime.now();

        String nowFormatted = DateTimeFormatter.ISO_TIME.format(now);
        System.out.println(nowFormatted);
    }

}