package com.oilpay.core.storage

interface OnBoardingStorage {
    fun onBoardingStatus(): Boolean
    fun setOnBoardingStatus(isViewed: Boolean = true)
}