package com.eyalya.test.asiotech.logic;

import com.eyalya.test.asiotech.models.AlgResult;
import com.eyalya.test.asiotech.models.Bag;
import com.eyalya.test.asiotech.models.Trip;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class BagTripsCalculator {
    // Default const values 1.01-3.0Kg
    public static final float MINIMUM_WEIGHT = 1.01f;
    public static final float MAXIMUM_WEIGHT = 3f;

    // This is the algorithm, it takes an array of bags and brings back AlgResult
    AlgResult calculateBagTrips(ArrayList<Bag> bags) {
        //this is the returned value
        ArrayList<Trip> trips = new ArrayList<>();
        // this is a list of all the bags already thrown
        ArrayList<Bag> thrownBags = new ArrayList<>();

        // Sort bags based on weight in ascending order
        bags.sort(Comparator.comparingDouble(bag -> bag.weight));

        // Iterate through bags
        for (int i = 0; i < bags.size(); i++) {
            Trip currentTrip = new Trip();
            Bag bagA = bags.get(i);

            // Start by adding the lightest bag
            if (currentTrip.canAddBag(bagA) && !thrownBags.contains(bagA)) {
                currentTrip.addBag(bagA);
                thrownBags.add(bagA);

                // Iterate through bags in reverse order to find the heaviest bag
                for (int j = bags.size() - 1; j > 0; j--) {
                    Bag bagB = bags.get(j);

                    // Add the heaviest bag if it can be added
                    if (currentTrip.canAddBag(bagB) && !thrownBags.contains(bagB)) {
                        currentTrip.addBag(bagB);
                        thrownBags.add(bagB);
                    }
                }
                trips.add(currentTrip);
            }
        }
        return new AlgResult(trips.size(), trips);
    }

    // This is an example of using the Algorithm
    public static void main(String[] args) {
        System.out.println("Calculating Minimum Bag Trips! ...");

        ArrayList<Bag> bags = new ArrayList<>();
        // Example input #1
        bags.add(new Bag(1, 2.0f));
        bags.add(new Bag(2, 3.0f));
        bags.add(new Bag(3, 1.01f));
        bags.add(new Bag(4, 1.5f));
        bags.add(new Bag(5, 1.7f));
        bags.add(new Bag(7, 1.3f));
        bags.add(new Bag(8, 1.5f));
        // Output is
        // Minimum Trips Needed: 5
        // Trips:
        // Trip 1: [Bag #3 (1.01)Kg, Bag #5 (1.7)Kg]
        // Trip 2: [Bag #7 (1.3)Kg, Bag #8 (1.5)Kg]
        // Trip 3: [Bag #4 (1.5)Kg]
        // Trip 4: [Bag #1 (2.0)Kg]
        // Trip 5: [Bag #2 (3.0)Kg]

        // Example input #2
        /*
        bags.add(new Bag(1, 2.0f));
        bags.add(new Bag(2, 3.0f));
        bags.add(new Bag(3, 1.65f));
        bags.add(new Bag(4, 1.05f));
        bags.add(new Bag(5, 1.25f));
        bags.add(new Bag(6, 1.70f));
        bags.add(new Bag(7, 1.99f));
        bags.add(new Bag(8, 1.01f));
        */
        // Output is:
        // Minimum Trips Needed: 5
        // Trips:
        // Trip 1: [Bag #8 (1.01)Kg, Bag #7 (1.99)Kg]
        // Trip 2: [Bag #4 (1.05)Kg, Bag #6 (1.7)Kg]
        // Trip 3: [Bag #5 (1.25)Kg, Bag #3 (1.65)Kg]
        // Trip 4: [Bag #1 (2.0)Kg]
        // Trip 5: [Bag #2 (3.0)Kg]
        // Example input #3
        // bags.addAll(getRandomBags());

        BagTripsCalculator calculator = new BagTripsCalculator();
        AlgResult result = calculator.calculateBagTrips(bags);

        System.out.println("Minimum Trips Needed: " + result.minimumTripsNeeded);
        System.out.println("Trips:");
        for (int i = 0; i < result.trips.size(); i++) {
            Trip trip = result.trips.get(i);
            System.out.println("Trip " + (i + 1) + ": " + trip.bags);
        }
    }

    //function for testing different values.
    public static ArrayList<Bag> getRandomBags() {
        ArrayList<Bag> bags = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < random.nextInt(12); i++) {
            float weight = MINIMUM_WEIGHT + random.nextFloat() * (MAXIMUM_WEIGHT - MINIMUM_WEIGHT);
            bags.add(new Bag(i + 1, weight));
        }
        return bags;
    }
}