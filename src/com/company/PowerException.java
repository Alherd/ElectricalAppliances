package com.company;

public class PowerException extends Exception {
    int power;

    public PowerException(String message, int power) {
        super(message);
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}

