package com.kotlin.baselibrary.common

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

class AppManager private constructor(){

    val mActivityStack = Stack<Activity>()
    companion object{
        val instance by lazy {
             AppManager()
        }
    }

    /**
     * 入栈
     */
    fun pushActivity(activity: Activity){
        mActivityStack.push(activity)
    }

    /**
     * 出栈
     */
    fun removeActivity(activity: Activity){
        mActivityStack.remove(activity)
    }

    /**
     * 获取当前栈顶Activity
     */
    fun currentActivity():Activity{
        return mActivityStack.lastElement()
    }

    /**
     * 移除所有Activity
     */
    fun finishAllActivity(){
        for (activity in mActivityStack){
            activity.finish()
        }
        mActivityStack.clear()
    }

    /**
     * 退出程序
     */
    @SuppressLint("ServiceCast")
    fun exitApp(context: Context){
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }

}