package info.tkt989.kanmokusupport.views

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.MarginLayoutParamsCompat
import androidx.core.view.marginLeft
import androidx.recyclerview.widget.RecyclerView
import info.tkt989.kanmokusupport.models.Situation

class TemplateAdapter(val context: Context, situationList: List<Situation>) : RecyclerView.Adapter<TemplateAdapter.TemplateViewHolder>() {
    var listener: ((text: TextView) -> Unit)? = null
    val list: List<Pair<String, String>>

    init {
        val list = mutableListOf<Pair<String, String>>()

        situationList.forEach {
            list.add(Pair("situation", it.title))

            it.templates.forEach {
                list.add(Pair("template", it.content))
            }
        }
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemplateViewHolder {
        val text = TextView(context)
        text.textSize = 32.0f
        return TemplateViewHolder(text)
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    override fun onBindViewHolder(holder: TemplateViewHolder, position: Int) {
        val data = this.list[position]

        holder.text.text = data.second
        if (data.first == "situation") {
            holder.text.typeface = Typeface.DEFAULT_BOLD
            holder.text.setOnClickListener { }
        } else {
            holder.text.typeface = Typeface.DEFAULT
            holder.text.setOnClickListener { listener?.invoke(holder.text) }
        }
    }

    class TemplateViewHolder(val text: TextView) : RecyclerView.ViewHolder(text) {}
}