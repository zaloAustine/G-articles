package com.example.kotlinstarter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kotlinstarter.Adapters.DnaRecyclerviewAdapter
import com.example.kotlinstarter.Adapters.PreviousRecyclerviewAdapter
import com.example.kotlinstarter.R
import com.example.kotlinstarter.models.Doc
import com.example.kotlinstarter.models.PreviousDocs
import com.example.kotlinstarter.utils.Done
import com.example.kotlinstarter.utils.Loading
import com.example.kotlinstarter.viewmodels.HistoryActivityViewModel
import com.example.kotlinstarter.viewmodels.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.recyclerview
import kotlinx.android.synthetic.main.activity_main.searchProgress
import timber.log.Timber
@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {
    private var recyclerAdapter: PreviousRecyclerviewAdapter? = null
    private var dataSet: MutableList<PreviousDocs> = ArrayList()


    private val historyActivityViewModel: HistoryActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        recyclerAdapter = PreviousRecyclerviewAdapter(dataSet)
        setUpRecyclerView()
        getPreviousDoc()
        observePreviousDocs()
        observeLoadingState()
    }

    fun observeCount(){
        total.text = dataSet.size.toString()
    }

    private fun observeLoadingState() {
        historyActivityViewModel.viewState.observe(this, {
            Timber.e(it.toString())
            when (it) {
                is Loading -> searchProgress.visibility = View.VISIBLE
                is Done -> searchProgress.visibility = View.GONE

            }
        })
    }

    private fun observePreviousDocs() {
        historyActivityViewModel.previousLiveData.observe(this,{
            dataSet.clear()
            it?.let { it1 -> dataSet.addAll(it) }
            Timber.e(dataSet.size.toString())
            observeCount()

            recyclerAdapter!!.notifyDataSetChanged()
        })
    }

    private fun getPreviousDoc() {
        historyActivityViewModel.getPreviousArticles()
    }

    private fun setUpRecyclerView() {

        recyclerview.apply {
            layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            itemAnimator = DefaultItemAnimator()
            adapter = recyclerAdapter
        }
    }
}