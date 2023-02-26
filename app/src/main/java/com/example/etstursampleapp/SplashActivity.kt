package com.example.etstursampleapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.etstursampleapp.databinding.ActivitySplashBinding
import com.example.etstursampleapp.ui.main.MainActivity
import com.example.etstursampleapp.util.delegate.viewBinding
import com.example.etstursampleapp.util.extension.isConnected
import com.example.etstursampleapp.util.extension.showErrorDialog
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivitySplashBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
        remoteConfig.fetchAndActivate().addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Log.d("", "Fetch updated")
            } else {
                Log.d("", "Fetch failed")
            }

            val splashText = FirebaseRemoteConfig.getInstance().getString("SplashText")
            binding.textViewSplashName.text = splashText

            if (isConnected()) {
                Thread {
                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }, 3000)
                }.start()
            } else {
                showErrorDialog(getString(R.string.lbl_error_dialog_message))
            }
        }
    }
}
