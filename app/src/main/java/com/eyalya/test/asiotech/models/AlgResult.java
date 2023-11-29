package com.eyalya.test.asiotech.models;

import java.util.ArrayList;

public class AlgResult {
    public int minimumTripsNeeded;
    public ArrayList<Trip> trips;

    public AlgResult(int minimumTripsNeeded, ArrayList<Trip> trips) {
        this.minimumTripsNeeded = minimumTripsNeeded;
        this.trips = trips;
    }
}