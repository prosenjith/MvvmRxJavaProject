package com.example.mvvmrxjavaproject.data.network

import com.google.gson.annotations.SerializedName
import okhttp3.ResponseBody

data class RequestException(
    var status: String = "",
    override var message: String = "",
    var statusCode: Int = 0
) : Exception(message)

data class ApiException(
    val status: String,
    val errorBody: ResponseBody?,
    override val message: String
) : Exception(message)

data class ApiError(
    @SerializedName("status")
    var status: String = "",

    @SerializedName("status_code")
    var statusCode: Int = 0,

    @SerializedName("message")
    var message: String? = null,

    @SerializedName("error")
    var error: Error? = null,
)