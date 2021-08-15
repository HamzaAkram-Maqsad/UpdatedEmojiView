package com.example.emojiview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.emojiview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var blurView: BlurView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        blurView = BlurView(this)
//        binding.parentLayout.viewTreeObserver.addOnGlobalLayoutListener {
//         //   saveParentWidth(binding.parentLayout.width)
//            Toast.makeText(this, "${binding.parentLayout.width}", Toast.LENGTH_SHORT).show()
//
//        }
//
//        blurView?.layoutParams = ConstraintLayout.LayoutParams(
//            ConstraintLayout.LayoutParams.MATCH_PARENT,
//            ConstraintLayout.LayoutParams.MATCH_PARENT,
//        )
//        binding.root.addView(blurView!!)
//        blurView?.visibility = View.GONE
//        blurView?.setOnClickListener {
//            binding.customView.slideIt()
//        }
//
//        binding.show.setOnClickListener {
//            binding.customView.setBlurView(blurView!!)
//            binding.customView.slideIt()
//
//        }
//        binding.customView.videoSettingsClickListener = object : VideoSettingsClickListener {
//            override fun onQualityClick() {
//                blurView?.visibility = View.GONE
//            }
//
//            override fun onPlaybackSpeedClick() {
//                TODO("Not yet implemented")
//            }
//
//            override fun onCaptionsClick() {
//                TODO("Not yet implemented")
//            }
//
//            override fun onReportClick() {
//                TODO("Not yet implemented")
//            }
//
//
//        }





    }


}