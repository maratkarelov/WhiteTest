package com.example.white.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.white.R
import com.example.white.core.BaseActivity
import com.example.white.ui.list.MyListFragment

class MainActivity : BaseActivity() {
    override fun getContentLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, MyListFragment())
            .commit()

    }
}