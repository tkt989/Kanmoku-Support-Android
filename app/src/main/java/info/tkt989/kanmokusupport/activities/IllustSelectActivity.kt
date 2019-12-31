package info.tkt989.kanmokusupport.activities

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.GridLayoutManager
import info.tkt989.kanmokusupport.R
import info.tkt989.kanmokusupport.extensions.toUri
import info.tkt989.kanmokusupport.views.IllustAdapter
import kotlinx.android.synthetic.main.activity_drawing.*
import kotlinx.android.synthetic.main.activity_illust_select.*
import java.io.File
import java.io.FileOutputStream

class IllustSelectActivity : AppCompatActivity() {
    val illustList = listOf(
        R.drawable.face1,
        R.drawable.face2,
        R.drawable.face3,
        R.drawable.face4,
        R.drawable.face5,
        R.drawable.face6,
        R.drawable.face7,
        R.drawable.face8,
        R.drawable.face9
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_illust_select)

        val adapter = IllustAdapter(this, this.illustList)
        list.layoutManager = GridLayoutManager(this, 2)
        list.adapter = adapter

        adapter.listener = { image, resId ->
            image.setBackgroundColor(Color.WHITE)
            val bitmap = image.drawable.toBitmap()
            val intent = Intent(this, ShowIllustActivity::class.java)
            intent.putExtra("resId", resId)
            startActivity(intent)
        }
    }
}
