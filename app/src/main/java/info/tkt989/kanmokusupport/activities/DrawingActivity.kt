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
            intent.putExtra("bitmap", bitmapToUri(drawing.getBitmap()))
            startActivity(intent)
        }
    }

    private fun bitmapToUri(bitmap: Bitmap): Uri {
        val fileName: String = System.currentTimeMillis().toString() + ".jpg"
        val file = File(cacheDir, fileName)
        val fileOutputStream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
        fileOutputStream.close()
        return Uri.fromFile(file)
    }
}
