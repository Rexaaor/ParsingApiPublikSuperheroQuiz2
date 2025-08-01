package edu.unikom.parsingapipubliksuperheroquiz2.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import edu.unikom.parsingapipubliksuperheroquiz2.R
import edu.unikom.parsingapipubliksuperheroquiz2.data.model.SuperheroResponse

class UserAdapter : RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    private val heroes = mutableListOf<SuperheroResponse>()

    fun setData(newData: List<SuperheroResponse>) {
        heroes.clear()
        heroes.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_user, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = heroes[position]
        holder.tvName.text = hero.name
        holder.tvFullName.text = hero.biography.fullName
        Glide.with(holder.itemView.context)
            .load(hero.images.imageUrl)
            .circleCrop()
            .into(holder.ivAvatar)
    }

    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.itemName)
        val tvFullName: TextView = view.findViewById(R.id.itemBioName)
        val ivAvatar: ImageView = view.findViewById(R.id.itemAvatar)
    }
}