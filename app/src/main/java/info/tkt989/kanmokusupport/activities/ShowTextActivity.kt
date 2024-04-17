package info.tkt989.kanmokusupport.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import info.tkt989.kanmokusupport.MyApplication
import info.tkt989.kanmokusupport.R
import info.tkt989.kanmokusupport.databinding.ActivityShowTextBinding
import info.tkt989.kanmokusupport.models.Direction

class ShowTextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as MyApplication

        binding.text.text = intent?.extras?.getString("text")

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
