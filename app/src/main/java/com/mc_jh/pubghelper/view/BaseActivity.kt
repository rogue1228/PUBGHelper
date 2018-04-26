package com.mc_jh.pubghelper.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.mc_jh.pubghelper.R

abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutRes(): Int

    open fun isHomeAsUpEnabled():Boolean{
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getLayoutRes() != 0) {
            setContentView(getLayoutRes())
            setupToolbar()
        }
    }

    private fun setupToolbar() {
        findViewById<Toolbar>(R.id.toolbar)?.let {
            setSupportActionBar(it)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(isHomeAsUpEnabled())
                setDisplayShowTitleEnabled(true)
            }
        }
    }

}