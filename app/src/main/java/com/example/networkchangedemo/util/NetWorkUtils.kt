package com.example.networkchangedemo.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import com.example.networkchangedemo.NetWorkManager

/**
 * @author Chuck
 * @description:
 * @date :2020-08-14 14:32
 */
object NetWorkUtils {

    /**
     * 网络是否可用
     */
    fun isNewWorkAvailable(): Boolean {
        val connMgr: ConnectivityManager =
            NetWorkManager.getDefault().getApplication()?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connMgr.allNetworkInfo
        for (networkInfo in info) {
            if (networkInfo.state == NetworkInfo.State.CONNECTED) {
                return true
            }
        }
        return false
    }

    /**
     * 获取当前网络类型
     */
    fun getNetType(): NetType? {
        val connMgr: ConnectivityManager =
            NetWorkManager.getDefault().getApplication()?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val netWorkInfo: NetworkInfo? = connMgr.activeNetworkInfo ?: return NetType.NONE

        return when (netWorkInfo?.type) {
            ConnectivityManager.TYPE_MOBILE -> {
                if (netWorkInfo.extraInfo.toLowerCase() == "cmnet") {
                    NetType.CMNET
                } else {
                    NetType.CMWAP
                }
            }
            ConnectivityManager.TYPE_WIFI -> {
                NetType.WIFI
            }
            else -> NetType.NONE
        }
    }

}