package info.tkt989.kanmokusupport.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import info.tkt989.kanmokusupport.R
import kotlinx.android.synthetic.main.view_menu_button.view.*

class MenuButton(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.view_menu_button, this)

        context.obtainStyledAttributes(attrs, R.styleable.MenuButton).apply {
            this@MenuButton.text.text = getString(R.styleable.MenuButton_text)
            this@MenuButton.image.setImageResource(getResourceId(R.styleable.MenuButton_image, 0))

            recycle()
        }
    }
}