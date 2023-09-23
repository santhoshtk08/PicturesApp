package com.example.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstapp.ui.theme.MyFirstAppTheme
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : ComponentActivity() {

    private lateinit var imageView: ImageView
    private lateinit var previousButton: ImageButton
    private lateinit var nextButton: ImageButton

    private var currentImageIndex = 0

    private val imageIds = listOf(
        R.drawable.acer01,
        R.drawable.acer02,
        R.drawable.acer03,
        R.drawable.acer04,
        R.drawable.acer05
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        previousButton = findViewById(R.id.btnPrev)
        nextButton = findViewById(R.id.btnNext)
        imageView = findViewById(R.id.image)

        updateImage()

        previousButton.setOnClickListener {
            showPreviousImage()
        }

        nextButton.setOnClickListener {
            showNextImage()
        }
    }
    private fun updateImage() {
        imageView.setImageResource(imageIds[currentImageIndex])
    }

    private fun showPreviousImage() {
        if (currentImageIndex == 0) {
            currentImageIndex = imageIds.size - 1 // Go to the last image
        } else {
            currentImageIndex--
        }
        updateImage()
    }

    private fun showNextImage() {
        if (currentImageIndex == imageIds.size - 1) {
            currentImageIndex = 0 // Go to the first image
        } else {
            currentImageIndex++
        }
        updateImage()
    }
}


