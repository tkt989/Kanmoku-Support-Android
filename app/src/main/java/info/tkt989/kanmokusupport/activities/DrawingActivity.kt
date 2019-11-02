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
import info.tkt989.kanmokusupport.extensions.toUri
import kotlinx.android.synthetic.main.activity_drawing.*
import java.io.File
import java.io.FileOutputStream

class DrawingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawing)

        delete.setOnClickListener {
            drawing.clearCanvas()
        }

        show.setOnClickListener {
            val intent = Intent(this, ShowDrawingActivity::class.java)
            intent.putExtra("bitmap", drawing.getBitmap().toUri(this))
            startActivity(intent)
        }
    }
}
