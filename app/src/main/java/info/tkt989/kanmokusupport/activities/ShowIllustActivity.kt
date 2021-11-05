package info.tkt989.kanmokusupport.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import info.tkt989.kanmokusupport.MyApplication
import info.tkt989.kanmokusupport.R
import info.tkt989.kanmokusupport.models.Direction
import kotlinx.android.synthetic.main.activity_show_drawing.*

class ShowIllustActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_illust)

        val app = application as MyApplication

        text.setImageBitmap(MediaStore.Images.Media.getBitmap(contentResolver, intent?.extras?.get("bitmap") as Uri?))

        back.setOnClickListener { finish() }
        rotate.setOnClickListener {
            if (app.prefsService.showDirection == Direction.NORMAL) {
                app.prefsService.showDirection = Direction.REVERSE
            } else {
                app.prefsService.showDirection = Direction.NORMAL
            }
            updateShowDirection(app.prefsService.showDirection)
        }

        updateShowDirection(app.prefsService.showDirection)
    }

    private fun updateShowDirection(showDirection: Direction) {
        if (showDirection == Direction.NORMAL) {
            text.rotationX = 0.0f
            text.rotationY = 0.0f
        } else {
            text.rotationX = 180.0f
            text.rotationY = 180.0f
        }
    }
}
