package com.example.networkchangedemo

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * @author Chuck
 * @description:
 * @date :2020-08-14 15:17
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        NetWorkManager.getDefault().init(this)
        this.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            }

            override fun onActivityResumed(activity: Activity) {

            }

        })
    }
}