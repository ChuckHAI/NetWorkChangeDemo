package com.example.networkchangedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.networkchangedemo.listener.NetChangeListener
import com.example.networkchangedemo.util.NetType

class MainActivity : AppCompatActivity(), NetChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NetWorkManager.getDefault().setNetChangeListener(this)
    }

    override fun onDisConnect() {
        Log.i("++++++++++++", "无网络")
    }

    override fun onConnect(netType: NetType) {
        Log.i("++++++++++++", "当前网路是" + netType.name)
    }

}
