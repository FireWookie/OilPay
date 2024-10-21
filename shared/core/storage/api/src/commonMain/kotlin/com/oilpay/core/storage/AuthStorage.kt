package com.oilpay.core.storage

interface AuthStorage {
    val isAuth: Boolean

    fun setAccessToken(token: String)
    fun setRefreshToken(token: String)
    fun getAccessToken(): String
    fun getRefreshToken(): String

    fun viewedOnBoarding()
    fun getStatusBoarding(): Boolean
}