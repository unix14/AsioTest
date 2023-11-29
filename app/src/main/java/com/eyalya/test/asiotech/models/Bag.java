package com.eyalya.test.asiotech.models;

public class Bag {
    public int id;
    public float weight;

    public Bag(int id, float weight) {
        this.id = id;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Bag #" + id + " (" + weight + ")Kg";
    }
}