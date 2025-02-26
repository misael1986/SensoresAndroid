package com.example.sensoresandroid

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val acelerometro = findViewById<ImageButton>(R.id.accelerometro_button)
        val camara= findViewById<ImageButton>(R.id.camara_button)
        val gps= findViewById<ImageButton>(R.id.gps_button)

        acelerometro.setOnClickListener {
            val intentAcc= Intent(this,AcelerometroActivity::class.java)
            startActivity(intentAcc)

        }

        camara.setOnClickListener {
            val intentCam= Intent(this,CamaraActivity::class.java)
            startActivity(intentCam)

        }

        gps.setOnClickListener {
            val intentGPS =Intent(this,MapsActivity::class.java)
            startActivity(intentGPS)

        }



    }
}