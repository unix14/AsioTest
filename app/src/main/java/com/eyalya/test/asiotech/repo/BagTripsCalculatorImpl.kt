package com.eyalya.test.asiotech.repo

import com.eyalya.test.asiotech.models.AlgResult
import com.eyalya.test.asiotech.models.Bag
import com.eyalya.test.asiotech.models.Trip
import javax.inject.Inject

// Constructor-injected, because Hilt needs to know how to
// provide instances of AnalyticsServiceImpl, too.
class BagTripsCalculatorImpl @Inject constructor() : TripsCalculator {

    override fun calculateBagTrips(bags: ArrayList<Bag>): AlgResult {
        //this is the returned value
        val trips = java.util.ArrayList<Trip>()
        // this is a list of all the bags already thrown
        val thrownBags = java.util.ArrayList<Bag>()

        // Sort bags based on weight in ascending order
        bags.sortWith(Comparator.comparingDouble { bag: Bag -> bag.weight.toDouble() })

        // Iterate through bags
        for (i in bags.indices) {
            val currentTrip = Trip()
            val bagA = bags[i]

            // Start by adding the lightest bag
            if (currentTrip.canAddBag(bagA) && !thrownBags.contains(bagA)) {
                currentTrip.addBag(bagA)
                thrownBags.add(bagA)

                // Iterate through bags in reverse order to find the heaviest bag
                for (j in bags.size - 1 downTo 1) {
                    val bagB = bags[j]

                    // Add the heaviest bag if it can be added
                    if (currentTrip.canAddBag(bagB) && !thrownBags.contains(bagB)) {
                        currentTrip.addBag(bagB)
                        thrownBags.add(bagB)
                    }
                }
                trips.add(currentTrip)
            }
        }
        return AlgResult(trips.size, trips)
    }
}