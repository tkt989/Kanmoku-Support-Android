package info.tkt989.kanmokusupport.activities

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.GridLayoutManager
import info.tkt989.kanmokusupport.R
import info.tkt989.kanmokusupport.databinding.ActivityIllustSelectBinding
import info.tkt989.kanmokusupport.extensions.toUri
import info.tkt989.kanmokusupport.views.IllustAdapter
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

    private lateinit var binding: ActivityIllustSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIllustSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = IllustAdapter(this, this.illustList)
        binding.list.layoutManager = GridLayoutManager(this, 2)
        binding.list.adapter = adapter

        adapter.listener = { image ->
            val intent = Intent(this, ShowIllustActivity::class.java)
            val bitmap = image.drawable.toBitmap()
            bitmap.setHasAlpha(true)
            intent.putExtra("bitmap", bitmap.toUri(this))
            startActivity(intent)
        }
    }
}
