package com.example.bolo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bolo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flContent,GenreListFragment())
            addToBackStack("")
            commit()
        }
    }
}