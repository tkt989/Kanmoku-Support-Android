package info.tkt989.kanmokusupport.activities

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.FileProvider
import info.tkt989.kanmokusupport.BuildConfig
import info.tkt989.kanmokusupport.R
import info.tkt989.kanmokusupport.databinding.ActivityDrawingBinding
import info.tkt989.kanmokusupport.extensions.toUri
import java.io.File
import java.io.FileOutputStream

class DrawingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDrawingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.delete.setOnClickListener {
            binding.drawing.clearCanvas()
        }

        binding.show.setOnClickListener {
            val intent = Intent(this, ShowDrawingActivity::class.java)
            intent.putExtra("bitmap", binding.drawing.getBitmap().toUri(this))
            startActivity(intent)
        }
    }
}
