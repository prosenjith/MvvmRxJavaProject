package com.example.mvvmrxjavaproject.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import androidx.lifecycle.LiveData
import com.example.mvvmrxjavaproject.data.network.ConnectivityHelper
import com.example.mvvmrxjavaproject.di.qualifier.ApplicationContext
import javax.inject.Inject

class ConnectivityLiveData @Inject constructor(
    @ApplicationContext private val context: Context
) : LiveData<Boolean>() {

    private var connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            postValue(true)
        }

        override fun onLost(network: Network) {
            postValue(false)
        }
    }

    override fun onActive() {
        super.onActive()
        postValue(ConnectivityHelper.isConnectedToInternet(context))
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}
