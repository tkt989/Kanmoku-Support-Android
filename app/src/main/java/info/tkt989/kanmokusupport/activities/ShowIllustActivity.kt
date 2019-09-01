package info.tkt989.kanmokusupport.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import info.tkt989.kanmokusupport.R
import kotlinx.android.synthetic.main.activity_show_drawing.*

class ShowIllustActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_illust)

        image.setImageBitmap(MediaStore.Images.Media.getBitmap(contentResolver, intent?.extras?.get("bitmap") as Uri?))

        back.setOnClickListener { finish() }    }
}
