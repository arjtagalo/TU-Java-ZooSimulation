package com.example.ooput.utils;

import java.util.Random;

public class TicketGenerator {
    public static String generateCode() {
        int random = new Random().nextInt(9000) + 1000;
        return "ZOO-" + random;
    }
}
