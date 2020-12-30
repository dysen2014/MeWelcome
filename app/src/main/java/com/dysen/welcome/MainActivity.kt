package com.dysen.welcome

import android.os.Bundle
import com.dysen.baselib.base.BaseActivity
import com.dysen.baselib.data.Keys
import com.dysen.baselib.model.LiveDataManager
import com.dysen.baselib.utils.ColorUtil
import com.me.welcome.WelcomeActivity
import com.me.welcome.WelcomeModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    var datas = mutableListOf<WelcomeModel>()


    override fun layoutId(): Int = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        initData()
        WelcomeActivity.newInstance(this, datas, true)

        LiveDataManager.instance?.with<Boolean>(Keys.WELCOME_BACK)?.observer(this, {
            nextMain()
        })
    }

    private fun nextMain() {
//        newInstance(this, SecondActivity::class.java, true)
        setIsVisible(cll, true)
    }

    private fun initData() {
        for (i in 0..2) {
            datas.add(WelcomeModel(imgUrl = ColorUtil.randomImage()))
        }
    }

}