package com.example.kotlinstarter.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstarter.R

class PreviousRecyclerviewAdapter(
    private val dataSet: MutableList<PreviousDocs>
): RecyclerView.Adapter<PreviousRecyclerviewAdapter.DnaViewHolder>() {


    class DnaViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textView: TextView =  view.findViewById(R.id.textView)
        val journal:TextView = view.findViewById(R.id.journal)
        val cardView: CardView = view.findViewById(R.id.cardView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DnaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dna_list_view, parent, false)
        return DnaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DnaViewHolder, position: Int) {
        holder.textView.text = dataSet[position].title_display
        holder.journal.text = dataSet[position].journal

//        //if position of item is a factor of 3 the fill the width
//        if(position%3==0){
//            //full width
//            val layoutParams = holder.cardView.layoutParams as StaggeredGridLayoutManager.LayoutParams
//            layoutParams.isFullSpan = true
//        }



    }

    override fun getItemCount():Int = dataSet.size
}

