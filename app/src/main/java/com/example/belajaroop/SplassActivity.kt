package com.example.belajaroop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.belajaroop.ui.main.MainActivity

class SplassActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long=3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splass)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this,
                MainActivity::class.java))
            Animatoo.animateZoom(this)
            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}
