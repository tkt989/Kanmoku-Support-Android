package info.tkt989.kanmokusupport.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import info.tkt989.kanmokusupport.R
import info.tkt989.kanmokusupport.databinding.ViewMenuButtonBinding

class MenuButton(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private var binding: ViewMenuButtonBinding

    init {
        binding = ViewMenuButtonBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)

        context.obtainStyledAttributes(attrs, R.styleable.MenuButton).apply {
            binding.text.text = getString(R.styleable.MenuButton_text)
            binding.image.setImageResource(getResourceId(R.styleable.MenuButton_image, 0))

            recycle()
        }
    }
}