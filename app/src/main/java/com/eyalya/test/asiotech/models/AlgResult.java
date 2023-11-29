package com.eyalya.test.asiotech.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AlgResult {
    public int minimumTripsNeeded;
    public ArrayList<Trip> trips;

    public AlgResult(int minimumTripsNeeded, ArrayList<Trip> trips) {
        this.minimumTripsNeeded = minimumTripsNeeded;
        this.trips = trips;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Algorithm Results:\n");
        result.append("Minimum Trips Needed: ").append(minimumTripsNeeded).append("\n");
        result.append("Trips:\n\n");

        for (int i = 0; i < trips.size(); i++) {
            Trip trip = trips.get(i);
            result.append("Trip ").append(i + 1).append(": ").append(trip).append("\n");
        }

        return result.toString();
    }
}