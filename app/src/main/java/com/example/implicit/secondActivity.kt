package com.example.implicit

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val acceptText: TextView = findViewById(R.id.txt_second)
        val receiveText: String? = intent.getStringExtra("INI DIKIRIM")
        acceptText.text = receiveText
    }
}