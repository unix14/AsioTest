package com.eyalya.test.asiotech.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eyalya.test.asiotech.models.Bag

class BagsListViewModel: ViewModel() {

    private val _bagsListData: MutableLiveData<ArrayList<Bag>> = MutableLiveData(arrayListOf())
    val bagsListData: LiveData<ArrayList<Bag>> = _bagsListData

    init {
//        _bagsListData.postValue()
    }

}