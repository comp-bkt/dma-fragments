package com.leedsbeckett.basicfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        if (fm.findFragmentById(R.id.container)==null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentOne.newInstance())
                .commitNow()
        }
    }
}