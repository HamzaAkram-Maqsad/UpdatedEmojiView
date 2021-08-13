package com.example.emojiview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.emojiview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.show.setOnClickListener {
            binding.customView.slideIt()
        }
        binding.customView.videoSettingsClickListener = object : VideoSettingsClickListener {
            override fun onQualityClick() {
                TODO("Not yet implemented")
            }

            override fun onPlaybackSpeedClick() {
                TODO("Not yet implemented")
            }

            override fun onCaptionsClick() {
                TODO("Not yet implemented")
            }

            override fun onReportClick() {
                TODO("Not yet implemented")
            }

        }
    }


}