package com.fadhlur.maps_wisata_mi2c

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailWisata : AppCompatActivity() {
    private lateinit var btndetail : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        btndetail = findViewById(R.id.btndetail)


        val latitude = intent.getDoubleExtra("latitude",0.0)
        val longitude = intent.getDoubleExtra("longitude",0.0)

        Toast.makeText(this,"latitude{$latitude} {$longitude}", Toast.LENGTH_SHORT).show()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_wisata)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btndetail.setOnClickListener(){
            val intentMenu2 = Intent(this@DetailWisata,
                MapsActivity::class.java)
            //put latitude longitude
            intentMenu2.putExtra("latitude",latitude)
            intentMenu2.putExtra("longitude",longitude)
            startActivity(intentMenu2)
        }
    }
}