package info.tkt989.kanmokusupport.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import info.tkt989.kanmokusupport.R
import kotlinx.android.synthetic.main.activity_show_text.*

class ShowTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_text)

        text.text = intent?.extras?.getString("text")

        back.setOnClickListener { finish() }
    }
}
