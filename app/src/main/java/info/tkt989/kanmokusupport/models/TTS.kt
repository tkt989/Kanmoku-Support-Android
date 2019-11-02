package info.tkt989.kanmokusupport.models

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log

class TTS(context: Context) : TextToSpeech.OnInitListener {
    private val tts: TextToSpeech = TextToSpeech(context, this)

    override fun onInit(status: Int) {
        if (status != TextToSpeech.SUCCESS) {
            Log.e("TTS", "initialize error")
        }

    }

    fun speak(text: String, onFinish: (() -> Unit) = { }) {
        tts.setOnUtteranceProgressListener(object: UtteranceProgressListener() {
            override fun onDone(p0: String?) {
                onFinish()
            }

            override fun onError(p0: String?) {
                onFinish()
            }

            override fun onStart(p0: String?) {
            }

        })
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id")
    }
}