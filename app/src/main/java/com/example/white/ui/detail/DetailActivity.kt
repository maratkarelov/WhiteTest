package com.example.white.ui.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.white.R
import com.example.white.core.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {
    companion object {
        const val URL = "url"
    }

    override fun getContentLayout(): Int {
        return R.layout.activity_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Glide.with(this).load(intent.getStringExtra(URL)).into(img_detail)
    }
}
