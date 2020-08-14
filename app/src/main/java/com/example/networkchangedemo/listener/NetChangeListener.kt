package com.example.networkchangedemo.listener

import com.example.networkchangedemo.util.NetType

/**
 * @author Chuck
 * @description:
 * @date :2020-08-14 14:37
 */
interface NetChangeListener {

    //有网络
    fun onConnect(netType: NetType)

    //没有网络
    fun onDisConnect()
}