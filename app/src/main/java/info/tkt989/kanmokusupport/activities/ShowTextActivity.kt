package info.tkt989.kanmokusupport.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import info.tkt989.kanmokusupport.MyApplication
import info.tkt989.kanmokusupport.R
import info.tkt989.kanmokusupport.models.Direction
import kotlinx.android.synthetic.main.activity_show_drawing.*
import kotlinx.android.synthetic.main.activity_show_text.*
import kotlinx.android.synthetic.main.activity_show_text.back
import kotlinx.android.synthetic.main.activity_show_text.rotate
import kotlinx.android.synthetic.main.activity_show_text.text

class ShowTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_text)

        val app = application as MyApplication

        text.text = intent?.extras?.getString("text")

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
