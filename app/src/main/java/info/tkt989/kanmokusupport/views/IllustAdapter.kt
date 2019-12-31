package info.tkt989.kanmokusupport.views

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

class IllustAdapter(val context: Context, val illustList: List<Int>) : RecyclerView.Adapter<IllustAdapter.IllustViewHolder>() {
    var listener: ((image: ImageView, id: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IllustViewHolder {
        val image = ImageView(context)
        image.adjustViewBounds = true
        return IllustViewHolder(image)
    }

    override fun getItemCount(): Int {
        return this.illustList.size
    }

    override fun onBindViewHolder(holder: IllustViewHolder, position: Int) {
        holder.image.setImageResource(this.illustList[position])
        holder.image.setOnClickListener { listener?.invoke(holder.image, this.illustList[position]) }
    }

    class IllustViewHolder(val image: ImageView) : RecyclerView.ViewHolder(image) {}
}