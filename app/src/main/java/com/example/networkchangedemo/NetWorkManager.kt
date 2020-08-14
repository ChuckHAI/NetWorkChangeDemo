package com.example.networkchangedemo

import android.app.Application
import android.content.IntentFilter
import com.example.networkchangedemo.listener.NetChangeListener
import com.example.networkchangedemo.receive.NetStateReceiver

/**
 * @author Chuck
 * @description:
 * @date :2020-08-14 14:29
 */
class NetWorkManager() {
    private var receiver: NetStateReceiver? = null
    private var application: Application? = null

    init {
        receiver = NetStateReceiver()
    }

    companion object {
        private var instance: NetWorkManager? = null
        fun getDefault(): NetWorkManager {
            if (instance == null) {
                instance = NetWorkManager()
            }
            return instance as NetWorkManager
        }
    }

    fun init(application: Application) {
        this.application = application

        //动态注册广播（兼容7.0）
        val filter = IntentFilter()
        filter.addAction(Constants.ANDROID_NET_ACTION)
        application.registerReceiver(receiver, filter)
    }

    fun setNetChangeListener(netChangeListener: NetChangeListener) {
        receiver?.setNetChangeListener(netChangeListener)
    }

    fun getApplication(): Application? {
        return application
    }


}