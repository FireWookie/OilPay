package com.oilpay.core.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.oilpay.core.storage.preferences.onBoarding
import com.oilpay.core.storage.preferences.onBoardingViewed
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

internal class OnBoardingStorageImpl(
    private val scope: CoroutineScope,
    private val dataStore: DataStore<Preferences>
): OnBoardingStorage {
    override fun onBoardingStatus(): Boolean = runBlocking {
        dataStore.data.first().onBoarding
    }

    override fun setOnBoardingStatus(isViewed: Boolean) {
        scope.launch {
            println("status changed to $isViewed")
            dataStore.edit { it.onBoardingViewed(isViewed) }
        }
    }

}