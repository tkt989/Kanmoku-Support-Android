package info.tkt989.kanmokusupport

import android.content.Intent
import android.content.res.AssetManager
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import info.tkt989.kanmokusupport.activities.DrawingActivity
import info.tkt989.kanmokusupport.activities.IllustSelectActivity
import info.tkt989.kanmokusupport.activities.TemplatesActivity
import info.tkt989.kanmokusupport.activities.WritingActivity
import info.tkt989.kanmokusupport.models.Situation
import jp.co.runners.rateorfeedback.RateOrFeedback
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        if ((application as MyApplication)?.launchCount == 10) {
            RateOrFeedback(this)
                .setPlayStoreUrl(getString(R.string.store_url))
                .setFeedbackEmail(getString(R.string.email))
                .setAskLikeAppDialogMessage(getString(R.string.rate_message))
                .setAskLikeAppDialogPositiveTitle(getString(R.string.rate_positive))
                .setAskLikeAppDialogNegativeTitle(getString(R.string.rate_negative))
                .setRequestReviewDialogMessage(getString(R.string.rate_review_message))
                .setRequestReviewDialogPositiveTitle(getString(R.string.rate_review_positive))
                .setRequestReviewDialogNegativeTitle(getString(R.string.rate_review_negative))
                .setRequestFeedbackDialogMessage(getString(R.string.rate_feedback_message))
                .setRequestFeedbackDialogPositiveTitle(getString(R.string.rate_feedback_positive))
                .setRequestFeedbackDialogNegativeTitle(getString(R.string.rate_feedback_negative))
                .show()
        }

        writing.setOnClickListener {
            startActivity(Intent(this, WritingActivity::class.java))
        }

        illust.setOnClickListener {
            startActivity(Intent(this, IllustSelectActivity::class.java))
        }

        drawing.setOnClickListener {
            startActivity(Intent(this, DrawingActivity::class.java))
        }

        templates.setOnClickListener {
            startActivity(Intent(this, TemplatesActivity::class.java))
        }
    }
}
