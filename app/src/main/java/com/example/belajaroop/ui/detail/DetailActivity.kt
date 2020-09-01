package com.example.belajaroop.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belajaroop.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val modul = intent.getStringExtra("modul")
        pdfView.fromAsset(modul).load()
    }
}
