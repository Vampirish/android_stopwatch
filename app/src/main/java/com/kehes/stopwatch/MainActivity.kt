package com.kehes.stopwatch

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.BoringLayout
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kehes.stopwatch.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var seconds: Int = 0
    private var running: Boolean = false
    private var wasRunning: Boolean = false
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

        savedInstanceState?.let {
            seconds = it.getInt(state.SECONDS.name)
            running = it.getBoolean(state.RUNNING.name)
            wasRunning = it.getBoolean(state.WAS_RUNNING.name)
        }

        runTimer()
    }

    private fun runTimer() {
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                val minutes = (seconds % 3600) / 60
                val time = String.format(Locale.getDefault(),
                    "%02d:%02d", minutes, seconds % 60)
                binding.timeView.text = time

                if (running) seconds++
                handler.postDelayed(this, 1000)
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(state.SECONDS.name, seconds)
        outState.putBoolean(state.RUNNING.name, running)
        outState.putBoolean(state.WAS_RUNNING.name, running)
        super.onSaveInstanceState(outState)
    }

    private fun pauseClick() {
        running = false
    }

    private fun startClick() {
        running = true
    }

    private fun resetClick() {
        seconds = 0
        running = false
    }

    override fun onStart() {
        super.onStart()
        Log.e(this.javaClass.name, ">>> onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(this.javaClass.name, ">>> onResume")
    }

    override fun onPause() {
        super.onPause()
//        running = wasRunning
        Log.e(this.javaClass.name, ">>> onPause")
    }

    override fun onStop() {
        super.onStop()
 //       running = false
        Log.e(this.javaClass.name, ">>> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(this.javaClass.name, ">>> onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
//        running = true
        Log.e(this.javaClass.name, ">>> onRestart")
    }
}

enum class state{
    RUNNING, SECONDS, WAS_RUNNING
}