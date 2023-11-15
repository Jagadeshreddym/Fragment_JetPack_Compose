package com.example.fragmentsample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fragmentsample.ui.theme.FragmentSampleTheme

class MainActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
        Log.i("ActivityTest", "onResume First Activity")

    }

    override fun onPause() {
        super.onPause()
        Log.i("ActivityTest", "onPause First Activity")

    }

    override fun onStart() {
        super.onStart()
        Log.i("ActivityTest", "onStart First Activity")

    }

    override fun onStop() {
        super.onStop()
        Log.i("ActivityTest", "onStop First Activity")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ActivityTest", "onDestroy First Activity")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ActivityTest", "onCreate First Activity")
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, RecipeListFragment())
            .commit()
    }
}