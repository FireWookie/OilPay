package com.oilpay.core.storage

interface AuthStorage {
    fun setAccessToken(token: String)
    fun setRefreshToken(token: String)
    fun getAccessToken(): String
    fun getRefreshToken(): String
}