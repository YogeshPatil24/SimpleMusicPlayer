package com.bodymassindex.clapapp

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var play = findViewById<FloatingActionButton>(R.id.play)
        var pause = findViewById<FloatingActionButton>(R.id.pause)
        var stop = findViewById<FloatingActionButton>(R.id.stop)

        seekBar = findViewById(R.id.stClapping)


        play.setOnClickListener { v ->
            Log.d("MainActivity", "Music is playing....: ")
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.loveyatri)

            }
            mediaPlayer?.start()
        }
        pause.setOnClickListener { v ->
            Log.d("MainActivity", "Music is pause....: ")

            mediaPlayer?.pause()
        }
        stop.setOnClickListener { v ->
            Log.d("MainActivity", "Music is stop....: ")
            mediaPlayer?.stop()

            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    private fun initializeSeekbar() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }
}