package com.example.implicit

import android.content.Intent
import android.health.connect.datatypes.ExerciseRoute.Location
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val websiteEdit: EditText = findViewById(R.id.website_edit_text)
        val openWebsiteButton: Button = findViewById(R.id.open_website_button)
        openWebsiteButton.setOnClickListener{
            val websiteurl = websiteEdit.text.toString()
            openWebsite(websiteurl)
        }

        val locationEdit: EditText = findViewById(R.id.location_edit_text)
        val locationButton: Button = findViewById(R.id.location_button)
        locationButton.setOnClickListener{
            val location = locationEdit.text.toString()
            openLocation(location)
        }

        val shareEdit: EditText = findViewById(R.id.share_edit_text)
        val shareButton: Button = findViewById(R.id.share_text_button)
        shareButton.setOnClickListener{
            val text = shareEdit.text.toString()
            shareText(text)
        }

        val implicitEdit: EditText = findViewById(R.id.implicit_edit_text)
        val implicitButton: Button = findViewById(R.id.implicit_button)
        implicitButton.setOnClickListener{
            val text = implicitEdit.text.toString()
            sendData(text)
        }
    }


    private fun openWebsite(url: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        Log.v("cek url", url)
        Toast.makeText(applicationContext, url, Toast.LENGTH_LONG).show()
        startActivity(intent)

    }
    private fun openLocation(location: String){
        val url = Uri.parse("geo:0,0?q=$location")
        val intent = Intent(Intent.ACTION_VIEW, url)
        intent.setPackage("com.google.android.apps.maps")
        Log.v("cek location", location)
        Toast.makeText(applicationContext, location, Toast.LENGTH_LONG).show()
        startActivity(intent)

    }
    private fun shareText(text: String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intent, "Pilih Aplikasi"))

    }
    private fun sendData(text: String){
        //buat objek intent untuk memulai secondactivity
        val intent = Intent(this, secondActivity::class.java)
        intent.putExtra("INI DIKIRIM", text)
        startActivity(intent)
    }

}