package com.example.motionlayout

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.example.motionlayout.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var currentState: Int = R.id.start
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        replaceFragment(HomeFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    //binding.cvMiniPlayer.visibility = View.VISIBLE
                    replaceFragment(HomeFragment())
                }
                R.id.audio -> {
                    //binding.cvMiniPlayer.visibility = View.VISIBLE
                    replaceFragment(AudioFragment())
                }
                R.id.video -> {
                    //binding.cvMiniPlayer.visibility = View.VISIBLE
                    replaceFragment(VideoFragment())
                }
                R.id.news -> {
                    //binding.cvMiniPlayer.visibility = View.VISIBLE
                    replaceFragment(NewsFragment())
                }
                R.id.settings -> {
                    //binding.cvMiniPlayer.visibility = View.GONE
                    replaceFragment(SettingsFragment())
                }
                else -> {}
            }
            true
        }

        binding.motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: MotionLayout, i: Int, i1: Int) {
                Log.i("MotionLayout", "Started: $i")
                currentState = motionLayout.currentState
            }

            override fun onTransitionChange(motionLayout: MotionLayout, i: Int, i1: Int, v: Float) {

                Log.i("MotionLayout", "Change: $i")
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout, i: Int) {

                currentState = motionLayout.currentState

                Log.i("MotionLayout", "Completed: ${motionLayout.currentState}")
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout,
                i: Int,
                b: Boolean,
                v: Float
            ) {

                Log.i("MotionLayout", "Trigger: $b")
            }
        })

        binding.ivDown.setOnClickListener {
            binding.motionLayout.transitionToEnd()
        }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()


    }

    override fun onBackPressed() {

        if (currentState == R.id.start){
            binding.motionLayout.transitionToEnd()
        } else{
            super.onBackPressed()
        }


    }
}