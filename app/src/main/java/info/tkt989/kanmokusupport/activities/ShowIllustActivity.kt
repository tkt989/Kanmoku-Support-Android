package info.tkt989.kanmokusupport.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import info.tkt989.kanmokusupport.MyApplication
import info.tkt989.kanmokusupport.databinding.ActivityShowIllustBinding
import info.tkt989.kanmokusupport.models.Direction

class ShowIllustActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowIllustBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowIllustBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as MyApplication

        binding.text.setImageBitmap(MediaStore.Images.Media.getBitmap(contentResolver, intent?.extras?.get("bitmap") as Uri?))

        binding.back.setOnClickListener { finish() }
        binding.rotate.setOnClickListener {
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
            binding.text.rotationX = 0.0f
            binding.text.rotationY = 0.0f
        } else {
            binding.text.rotationX = 180.0f
            binding.text.rotationY = 180.0f
        }
    }
}
