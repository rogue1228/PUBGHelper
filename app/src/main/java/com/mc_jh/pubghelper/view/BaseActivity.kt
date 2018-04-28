package com.mc_jh.pubghelper.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.mc_jh.pubghelper.R

abstract class BaseActivity : AppCompatActivity() {

    @get:LayoutRes
    abstract val layoutRes: Int

    open val useToolbar: Boolean = true

    open val isHomeAsUpEnabled: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutRes != 0) {
            setContentView(layoutRes)
            if (useToolbar) {
                setupToolbar()
            }
            setupViews()
        }
    }

    abstract fun setupViews()

    private fun setupToolbar() {
        findViewById<Toolbar>(R.id.toolbar)?.let {
            setSupportActionBar(it)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(isHomeAsUpEnabled)
                setDisplayShowTitleEnabled(true)
            }
        }
    }

}