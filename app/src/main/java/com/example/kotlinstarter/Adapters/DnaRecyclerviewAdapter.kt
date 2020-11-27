package com.example.kotlinstarter.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstarter.R
import com.example.kotlinstarter.models.Doc
import org.w3c.dom.Text

class DnaRecyclerviewAdapter(
    private val dataSet: MutableList<Doc>
): RecyclerView.Adapter<DnaRecyclerviewAdapter.DnaViewHolder>() {


    class DnaViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textView: TextView =  view.findViewById(R.id.textView)
        val authorName:TextView = view.findViewById(R.id.authorName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DnaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dna_list_view, parent, false)
        return DnaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DnaViewHolder, position: Int) {
        holder.textView.text = dataSet[position].title_display

    }

    override fun getItemCount():Int = dataSet.size
}

