package com.example.sensoresandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class CamaraActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var buttonCapture: Button
    private lateinit var cameraActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camara)

        imageView = findViewById(R.id.imageView)
        buttonCapture = findViewById(R.id.buttonCapture)

        cameraActivityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val imageUri = result.data?.data
                    imageView.setImageURI(imageUri)  // Mostramos la imagen en el ImageView en vivo
                } else {
                    Toast.makeText(this, "No se pudo capturar la imagen", Toast.LENGTH_LONG).show()
                }
            }

        buttonCapture.setOnClickListener {
            openCamera()
        }
    }

    // Metodo para abrir la cámara
    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraActivityResultLauncher.launch(intent)
    }
}
