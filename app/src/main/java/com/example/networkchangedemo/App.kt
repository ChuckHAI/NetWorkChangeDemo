package com.example.networkchangedemo

import android.app.Application

/**
 * @author Chuck
 * @description:
 * @date :2020-08-14 15:17
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        NetWorkManager.getDefault().init(this)
    }
}