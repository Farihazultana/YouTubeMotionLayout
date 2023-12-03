package com.example.motionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.motionlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()


    }
}