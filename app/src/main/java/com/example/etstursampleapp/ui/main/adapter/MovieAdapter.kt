package com.example.etstursampleapp.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.etstursampleapp.databinding.ItemMovieBinding
import com.example.etstursampleapp.ui.entity.MovieViewItem
import com.example.etstursampleapp.util.Constants
import com.example.etstursampleapp.util.extension.loadImage

@SuppressLint("NotifyDataSetChanged")
class MovieAdapter(
    private var list: ArrayList<MovieViewItem> = arrayListOf(),
    private var tempList: ArrayList<MovieViewItem> = arrayListOf(),
    private var block: (MovieViewItem) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(), Filterable {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemBinding = ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MovieViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = tempList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item: MovieViewItem = tempList[position]
        with(holder.binding) {
            textViewName.text = item.name
            textViewVote.text = item.voteAverage.toString()
            imageView.loadImage("${Constants.imageUrl}${item.posterPath}")
        }

        holder.itemView.setOnClickListener { block.invoke(item) }
    }

    fun setList(movies: List<MovieViewItem>) {
        list = ArrayList(movies)
        tempList = ArrayList(movies)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(char: CharSequence?): FilterResults {
                val charString = char?.toString() ?: ""
                tempList = if (charString.isEmpty()) list else {
                    val filteredList = ArrayList<MovieViewItem>()
                    list.filter {
                        (it.name.contains(char!!)) or (it.name.contains(char))
                    }.forEach { filteredList.add(it) }

                    filteredList
                }
                return FilterResults().apply { values = tempList }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                tempList = if (results?.values == null)
                    ArrayList()
                else
                    results.values as ArrayList<MovieViewItem>

                notifyDataSetChanged()
            }
        }
    }

    class MovieViewHolder(val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root)
}