package com.kehes.stopwatch

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kehes.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e(this.javaClass.name, ">>> onCreate")
        with(binding) {
            pauseButton.setOnClickListener {
                pauseClick()
            }
            startButton.setOnClickListener{
                startClick()
            }
            resetButton.setOnClickListener {
                resetClick()
            }
        }
    }

    private fun pauseClick() {
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show()
    }

    private fun startClick() {
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show()

    }

    private fun resetClick() {
        Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()
        Log.e(this.javaClass.name, ">>> onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.e(this.javaClass.name, ">>> onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(this.javaClass.name, ">>> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(this.javaClass.name, ">>> onDestroy")
    }
}