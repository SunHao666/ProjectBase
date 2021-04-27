package com.kotlin.base.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import com.kotlin.baselibrary.R

/*自定义进度条*/
class ProgressLoading private constructor(context: Context,theme:Int):Dialog(context,theme) {

    companion object{
        private lateinit var mDialog:ProgressLoading
        private lateinit var animationDrawable:AnimationDrawable
        fun create(context: Context):ProgressLoading{
            //样式
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)
            //自定义布局
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCanceledOnTouchOutside(false)
            mDialog.setCancelable(true)

            mDialog.window?.attributes?.gravity = Gravity.CENTER
            val attributes = mDialog.window?.attributes
            attributes?.dimAmount = 0.2f
            //设置属性
            mDialog.window?.attributes = attributes
            //动画
            val loadingView = mDialog.findViewById<ImageView>(R.id.iv_loading)
            animationDrawable = loadingView.background as AnimationDrawable

            return mDialog
        }
    }

    /*显示loading*/
    fun showLoading(){
        super.show()
        animationDrawable.start()
    }

    /*关闭loading*/
    fun hideLoading(){
        super.hide()
        animationDrawable.stop()
    }
}