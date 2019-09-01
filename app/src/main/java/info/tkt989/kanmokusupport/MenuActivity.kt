package info.tkt989.kanmokusupport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import info.tkt989.kanmokusupport.activities.DrawingActivity
import info.tkt989.kanmokusupport.activities.IllustSelectActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        illust.setOnClickListener {
            startActivity(Intent(this, IllustSelectActivity::class.java))
        }

        drawing.setOnClickListener {
            startActivity(Intent(this, DrawingActivity::class.java))
        }
    }
}
