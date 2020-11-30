package com.example.kotlinstarter.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager


/*
class DnaRecyclerviewAdapter(
    private val dataSet: MutableList<Doc>
): RecyclerView.Adapter<DnaRecyclerviewAdapter.DnaViewHolder>() {


        class DnaViewHolder(val binding: DnaListViewBinding) :RecyclerView.ViewHolder(binding.root){
            fun bind(item: Doc) {
                binding.doc = item

            }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DnaViewHolder {
        val binding = DnaListViewBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return DnaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DnaViewHolder, position: Int) {
        holder.bind(dataSet[position])

        if(dataSet[position].title_display!!.length >250){
            //full width
            val layoutParams = holder.binding.cardView.layoutParams as StaggeredGridLayoutManager.LayoutParams
            layoutParams.isFullSpan = true
        }

    }


    override fun getItemCount():Int = dataSet.size


    private fun setUser(doc: Doc, root: ViewGroup, context: Context) {
        val inflater = LayoutInflater.from(context)
        val binding: DnaListViewBinding = DnaListViewBinding.inflate(
            inflater,
            root,
            true
        )
        binding.doc = doc
    }

}

*/
