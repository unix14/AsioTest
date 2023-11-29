package com.eyalya.test.asiotech.repo

import com.eyalya.test.asiotech.models.AlgResult
import com.eyalya.test.asiotech.models.Bag

interface TripsCalculator {
  fun calculateBagTrips(bags: ArrayList<Bag>): AlgResult
}