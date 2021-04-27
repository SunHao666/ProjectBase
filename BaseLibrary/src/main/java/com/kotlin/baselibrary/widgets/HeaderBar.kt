package com.kotlin.base.widgets

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.baselibrary.R
import kotlinx.android.synthetic.main.layout_head_bar.view.*

class HeaderBar(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    FrameLayout(context, attrs, defStyleAttr) {
    private var isShowBack = true
    private var titleText: String? = null
    private var rightText: String? = null

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, -1)
    constructor(context: Context) : this(context, null, -1)

    init {
        //获取自定义属性
        val ta = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar)
        isShowBack = ta.getBoolean(R.styleable.HeaderBar_isShowBack, true)
        titleText = ta.getString(R.styleable.HeaderBar_titleText)
        rightText = ta.getString(R.styleable.HeaderBar_rightText)
        ta.recycle()
        initView()
    }

    /**
     * 根据属性设置UI
     */
    private fun initView() {
        /**
         * import kotlinx.android.synthetic.main.layout_head_bar.view.*
         * apply plugin: 'kotlin-android-extensions'
         */
        View.inflate(context, R.layout.layout_head_bar, this)

        mLeftIv.visibility = if (isShowBack) View.VISIBLE else View.GONE
        titleText?.let {
            mTitleTv.text = it
        }

        rightText?.let {
            mRightTv.text = it
            mRightTv.visibility = View.VISIBLE
        }

        mLeftIv.setOnClickListener {
            if (context is Activity){
                (context as Activity).finish()
            }
        }
    }

    /*获取返回按钮*/
    fun getLeftImg(): ImageView {
        return mLeftIv
    }

    /*获取标题*/
    fun getTitleView(): TextView {
        return mTitleTv
    }

    /*获取右侧view*/
    fun getRightView(): TextView {
        return mRightTv
    }

}