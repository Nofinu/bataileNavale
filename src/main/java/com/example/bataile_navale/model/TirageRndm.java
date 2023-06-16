package com.example.bataile_navale.model;

import java.util.Random;

public class TirageRndm implements Tirage{
    private Random random;

    public TirageRndm() {
        this.random = new Random();
    }

    @Override
    public int tirageRnd() {
        return random.nextInt(50);
    }
}
