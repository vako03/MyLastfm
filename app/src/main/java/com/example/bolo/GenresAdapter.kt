package com.example.bolo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bolo.databinding.LayoutGenreItemBinding
import com.example.bolo.models.Genre
import com.example.bolo.models.Tag

class GenreAdapter() : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    private val genres = mutableListOf<Tag>()
    private  var clickListener:((Tag) -> Unit)? = null




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val binding =
            LayoutGenreItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenreViewHolder(binding)
    }
    fun updateAll(genre: List<Tag>) {
        genres.addAll(genre)
        notifyDataSetChanged()
    }
    fun setOnItemClickListener(listener:(Tag) -> Unit){
        this.clickListener = listener
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val genre = genres[position]
        genre.apply {
            holder.binding.tvGenre.text =
                holder.binding.root.context.getString(R.string.music_genre,name.toString())
            holder.binding.tvListeners.text =
                holder.binding.root.context.getString(R.string.music_listener,reach.toString())

            holder.binding.root.setOnClickListener{
                clickListener?.invoke(genre)

            }


        }
    }

    override fun getItemCount(): Int {
        return genres.size
    }



class   GenreViewHolder(val binding: LayoutGenreItemBinding) :
    RecyclerView.ViewHolder(binding.root)

}