package com.eyalya.test.asiotech.modules

import com.eyalya.test.asiotech.repo.BagTripsCalculatorImpl
import com.eyalya.test.asiotech.repo.TripsCalculator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindTripsCalculator(
        bagTripsCalculatorImpl: BagTripsCalculatorImpl
    ): TripsCalculator
}