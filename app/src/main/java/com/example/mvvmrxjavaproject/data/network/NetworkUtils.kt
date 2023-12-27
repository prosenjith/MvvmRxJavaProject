package com.example.mvvmrxjavaproject.data.network

import android.content.Context
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

fun <T : Any> Single<Response<T>>.onResponse(): Single<T> {
    return this.map { response ->
        (if (response.isSuccessful) {
            response.body() ?: throw ApiException(
                response.code().toString(),
                null,
                response.message()
            )
        } else {
            throw ApiException(response.code().toString(), response.errorBody(), response.message())
        })
    }
}

fun <T : Any> Single<T>.onException(appContext: Context): Single<T> {
    return this.onErrorResumeNext { throwable ->
        Single.create { emitter ->
            if (throwable is ApiException) {
                emitter.onError(
                    ErrorHandler.parseRequestException(
                        appContext,
                        throwable.status,
                        throwable.errorBody,
                        throwable.message
                    )
                )
            } else {
                emitter.onError(ErrorHandler.parseIOException(appContext))
            }
        }
    }
}