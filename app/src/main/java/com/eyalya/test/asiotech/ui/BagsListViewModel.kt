package com.eyalya.test.asiotech.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eyalya.test.asiotech.models.AlgResult
import com.eyalya.test.asiotech.models.Bag
import com.eyalya.test.asiotech.repo.BagTripsCalculatorImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BagsListViewModel @Inject constructor(private val tripsCalculator: BagTripsCalculatorImpl): ViewModel() {

    private val _bagsListData: MutableLiveData<ArrayList<Bag>> = MutableLiveData(arrayListOf())
    val bagsListData: LiveData<ArrayList<Bag>> = _bagsListData

    private val _buttonState: MutableLiveData<ButtonState> = MutableLiveData(ButtonState.GONE)
    val buttonState: LiveData<ButtonState> = _buttonState

    private val _algResultData: MutableLiveData<AlgResult?> = MutableLiveData(null)
    val algResultData: LiveData<AlgResult?> = _algResultData

    enum class ButtonState {
        GONE, INACTIVE, ACTIVE
    }
    init {
//        val algResult: AlgResult = tripsCalculator.calculateBagTrips()
//        _bagsListData.postValue()
    }

    fun refreshTable(amountOfBags: Int) {
        _buttonState.postValue(ButtonState.INACTIVE)
        val randomBags = tripsCalculator.getRandomBags(amountOfBags)
        _bagsListData.postValue(randomBags)
        _buttonState.postValue(ButtonState.ACTIVE)
    }

    fun calculateTrips(bags: ArrayList<Bag>)  {
        _buttonState.postValue(ButtonState.INACTIVE)
        val result: AlgResult = tripsCalculator.calculateBagTrips(bags)
        _algResultData.postValue(result)
        _buttonState.postValue(ButtonState.GONE)
    }

}