package info.tkt989.kanmokusupport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import info.tkt989.kanmokusupport.activities.DrawingActivity
import info.tkt989.kanmokusupport.activities.IllustSelectActivity
import info.tkt989.kanmokusupport.activities.TemplatesActivity
import info.tkt989.kanmokusupport.activities.WritingActivity
import info.tkt989.kanmokusupport.databinding.ActivityMenuBinding
import jp.co.runners.rateorfeedback.RateOrFeedback

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        binding.writing.setOnClickListener {
            startActivity(Intent(this, WritingActivity::class.java))
        }

        binding.illust.setOnClickListener {
            startActivity(Intent(this, IllustSelectActivity::class.java))
        }

        binding.drawing.setOnClickListener {
            startActivity(Intent(this, DrawingActivity::class.java))
        }

        binding.templates.setOnClickListener {
            startActivity(Intent(this, TemplatesActivity::class.java))
        }
    }
}
