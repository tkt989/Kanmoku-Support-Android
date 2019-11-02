package info.tkt989.kanmokusupport.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import info.tkt989.kanmokusupport.R
import info.tkt989.kanmokusupport.models.Situation
import info.tkt989.kanmokusupport.models.TTS
import info.tkt989.kanmokusupport.views.TemplateAdapter
import kotlinx.android.synthetic.main.activity_templates.*
import kotlinx.android.synthetic.main.activity_templates.show
import kotlinx.android.synthetic.main.activity_templates.speak
import kotlinx.android.synthetic.main.activity_templates.text
import kotlinx.android.synthetic.main.activity_writing.*

class TemplatesActivity : AppCompatActivity() {
    private lateinit var tts: TTS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_templates)

        tts = TTS(this)

        val mapper = jacksonObjectMapper()
        val situations = mapper.readValue<List<Situation>>(resources.openRawResource(R.raw.templates))

        val adapter = TemplateAdapter(this, situations)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

        adapter.listener = {
            text.setText(text.text.toString() + it.text.toString() + "\n")
        }

        speak.setOnClickListener {
            speak.isEnabled = false
            tts.speak(text.text.toString()) {
                speak.post { speak.isEnabled = true }
            }
        }
        delete.setOnClickListener { text.setText("") }
        show.setOnClickListener {
            val intent = Intent(this, ShowTextActivity::class.java)
            intent.putExtra("text", text.text.toString())
            startActivity(intent)
        }
    }
}
