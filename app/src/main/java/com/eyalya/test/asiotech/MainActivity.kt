package com.eyalya.test.asiotech

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.eyalya.test.asiotech.databinding.ActivityMainBinding
import com.eyalya.test.asiotech.ui.BagsListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(BagsListFragment())
    }

    private fun loadFragment(fragment: Fragment) = with(binding) {
        supportFragmentManager.beginTransaction()
            .replace(container.id, fragment)
            .commit()
    }
}