package com.eyalya.test.asiotech.models;

import androidx.annotation.NonNull;
import com.eyalya.test.asiotech.logic.BagTripsCalculator;

import java.util.ArrayList;

public class Trip {
    public ArrayList<Bag> bags;

    public Trip() {
        bags = new ArrayList<>(0);
    }

    float getTotalWeight() {
        float totalWeight = 0f;
        for (Bag bag : bags) {
            totalWeight += bag.getWeight();
        }
        return totalWeight;
    }

    // checks if the given Bag can be entered into this Trip
    public boolean canAddBag(Bag bag) {
        float totalWeight = getTotalWeight();
        boolean isNotContainedInBags = !bags.contains(bag);
        boolean newWeightIsOk = bag.getWeight() + totalWeight <= BagTripsCalculator.MAXIMUM_WEIGHT;

        //if added weight value is below max value, and if the bag isn't contains the bag already
        return newWeightIsOk && isNotContainedInBags;
    }

    // add the bag into this Trip
    public void addBag(Bag bag) {
        bags.add(bag);
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < bags.size(); i++) {
            Bag bag = bags.get(i);
            result.append(bag);
            if (i < bags.size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}