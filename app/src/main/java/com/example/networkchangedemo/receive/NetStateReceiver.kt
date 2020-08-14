package com.example.networkchangedemo.receive

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.networkchangedemo.Constants
import com.example.networkchangedemo.listener.NetChangeListener
import com.example.networkchangedemo.util.NetType
import com.example.networkchangedemo.util.NetWorkUtils

/**
 * @author Chuck
 * @description:网络监听广播
 * @date :2020-08-14 14:46
 */
class NetStateReceiver : BroadcastReceiver() {

    private var netWork: NetType? = null
    private var netChangeListener: NetChangeListener? = null


    fun setNetChangeListener(netChangeListener: NetChangeListener) {
        this.netChangeListener = netChangeListener
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent == null || intent.action == null) {
            return
        }
        netWork = NetWorkUtils.getNetType()
        Log.i("++++++++++++", "网络发生了变化")

        if (intent.action.equals(Constants.ANDROID_NET_ACTION)) {
            if (NetWorkUtils.isNewWorkAvailable()) {
                netWork?.let { netChangeListener?.onConnect(it) }
            } else {
                netChangeListener?.onDisConnect()
            }
        }
    }
}