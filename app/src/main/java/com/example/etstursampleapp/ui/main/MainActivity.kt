package com.example.etstursampleapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.etstursampleapp.databinding.ActivityMainBinding
import com.example.etstursampleapp.util.delegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}