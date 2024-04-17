package info.tkt989.kanmokusupport.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import info.tkt989.kanmokusupport.R
import info.tkt989.kanmokusupport.databinding.ActivityTemplatesBinding
import info.tkt989.kanmokusupport.models.Situation
import info.tkt989.kanmokusupport.models.TTS
import info.tkt989.kanmokusupport.views.TemplateAdapter

class TemplatesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTemplatesBinding

    private lateinit var tts: TTS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplatesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tts = TTS(this)

        val mapper = jacksonObjectMapper()
        val situations = mapper.readValue<List<Situation>>(resources.openRawResource(R.raw.templates))

        val adapter = TemplateAdapter(this, situations)
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(this)

        adapter.listener = {
            binding.text.setText(binding.text.text.toString() + it.text.toString() + "\n")
        }

        binding.speak.setOnClickListener {
            binding.speak.isEnabled = false
            tts.speak(binding.text.text.toString()) {
                binding.speak.post { binding.speak.isEnabled = true }
            }
        }
        binding.delete.setOnClickListener { binding.text.setText("") }
        binding.show.setOnClickListener {
            val intent = Intent(this, ShowTextActivity::class.java)
            intent.putExtra("text", binding.text.text.toString())
            startActivity(intent)
        }
    }
}
