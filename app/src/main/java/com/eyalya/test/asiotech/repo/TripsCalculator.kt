package com.eyalya.test.asiotech.repo

import com.eyalya.test.asiotech.models.AlgResult
import com.eyalya.test.asiotech.models.Bag
import kotlin.random.Random

interface TripsCalculator {
  fun calculateBagTrips(bags: ArrayList<Bag>): AlgResult
  fun getRandomBags(maxValue: Int = Random.nextInt(12)): ArrayList<Bag>
}