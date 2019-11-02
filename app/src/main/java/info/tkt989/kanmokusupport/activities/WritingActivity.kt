package info.tkt989.kanmokusupport.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import info.tkt989.kanmokusupport.R
import info.tkt989.kanmokusupport.models.TTS
import kotlinx.android.synthetic.main.activity_writing.*

class WritingActivity : AppCompatActivity() {
    private lateinit var tts: TTS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing)

        tts = TTS(this)

        speak.setOnClickListener {
            speak.isEnabled = false
            tts.speak(text.text.toString()) {
                speak.post { speak.isEnabled = true }
            }
        }

        show.setOnClickListener {
            val intent = Intent(this, ShowTextActivity::class.java)
            intent.putExtra("text", text.text.toString())
            startActivity(intent)
        }
    }
}
