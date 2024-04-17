package info.tkt989.kanmokusupport.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import info.tkt989.kanmokusupport.databinding.ActivityWritingBinding
import info.tkt989.kanmokusupport.models.TTS

class WritingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWritingBinding

    private lateinit var tts: TTS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tts = TTS(this)

        binding.speak.setOnClickListener {
            binding.speak.isEnabled = false
            tts.speak(binding.text.text.toString()) {
                binding.speak.post { binding.speak.isEnabled = true }
            }
        }

        binding.show.setOnClickListener {
            val intent = Intent(this, ShowTextActivity::class.java)
            intent.putExtra("text", binding.text.text.toString())
            startActivity(intent)
        }
    }
}
