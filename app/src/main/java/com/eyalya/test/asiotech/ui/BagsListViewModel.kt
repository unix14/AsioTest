package com.eyalya.test.asiotech.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eyalya.test.asiotech.models.AlgResult
import com.eyalya.test.asiotech.models.Bag
import com.eyalya.test.asiotech.repo.BagTripsCalculatorImpl
import com.eyalya.test.asiotech.repo.TripsCalculator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BagsListViewModel @Inject constructor(private val tripsCalculator: BagTripsCalculatorImpl): ViewModel() {

    private val _bagsListData: MutableLiveData<ArrayList<Bag>> = MutableLiveData(arrayListOf())
    val bagsListData: LiveData<ArrayList<Bag>> = _bagsListData

    init {
//        val algResult: AlgResult = tripsCalculator.calculateBagTrips()
//        _bagsListData.postValue()
    }

    fun refreshTable(amountOfBags: Int) {

    }

}