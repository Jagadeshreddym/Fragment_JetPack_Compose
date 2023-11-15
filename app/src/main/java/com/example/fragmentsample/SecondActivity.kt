package com.example.fragmentsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()
        Log.i("ActivityTest", "onResume Second Activity")

    }

    override fun onPause() {
        super.onPause()
        Log.i("ActivityTest", "onPause Second Activity")

    }

    override fun onStart() {
        super.onStart()
        Log.i("ActivityTest", "onStart Second Activity")

    }

    override fun onStop() {
        super.onStop()
        Log.i("ActivityTest", "onStop Second Activity")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ActivityTest", "onDestroy Second Activity")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ActivityTest", "onCreate Second Activity")
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ThirdFragment())
            .commit()
    }
}