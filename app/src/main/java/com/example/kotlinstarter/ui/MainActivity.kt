package com.example.kotlinstarter.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.kotlinstarter.R
import com.example.kotlinstarter.databinding.ActivityMainBinding
import com.example.kotlinstarter.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
   // private var recyclerAdapter: DnaRecyclerviewAdapter? = null


    private val mainActivityViewModel  by viewModel<MainActivityViewModel>()
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

       /* searchView.addTextChangedListener(textWatcher)

        recyclerAdapter = DnaRecyclerviewAdapter(dataSet)
        setUpRecyclerView()
        getDna()
        observeDna()
        observeQuery()
        observeLoadingState()*/
        mainActivityViewModel.executeGetArticles("dna")
        observe()
    }

    private fun observe() {
        mainActivityViewModel.articleViewState.observe(this, { state ->
            if(state.isLoading){
                Log.d("MainActivity","******LOADING**********")
            }
            state.articleResults?.let { result ->
                Log.d("MainActivity","******RESULT**********===>${result}<===*******")
            }
            state.error?.let { error ->
                Log.e("MainActivity","**********ERROR********==>${error.message}")
            }
        })
    }


    /*private fun observeLoadingState() {
        mainActivityViewModel.viewState.observe(this, {
            Timber.e(it.toString())
            when (it) {
                is Loading -> searchProgress.visibility = View.VISIBLE
                is Done -> searchProgress.visibility = View.GONE

            }
        })
    }*/

    /*private fun setUpRecyclerView() {

        recyclerview.apply {
            layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            itemAnimator = DefaultItemAnimator()
            adapter = recyclerAdapter
        }
    }*/

    /*private fun getDna() {
        getConnection()
    }*/

    /*fun observeDna() {
        mainActivityViewModel.dnaLiveData.observe(this, {
            dataSet.clear()
            it?.let { it1 -> dataSet.addAll(it1) }
            Timber.e(dataSet.size.toString())

            totalHits.text = dataSet.size.toString()

            recyclerAdapter!!.notifyDataSetChanged()
        })
    }*/

    /*fun observeQuery() {
        mainActivityViewModel.queryString.observe(this, { searchQuery ->
            if (!searchQuery.trim().isEmpty()) {
                getDna()
            }

        })
    }*/


    /*private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // update view model
            if (s != null) {
                if (s.length >= 3) {
                    mainActivityViewModel.deleteAllSearches()
                    mainActivityViewModel.updateQueryString(s.toString())

                }
            }

        }

    }*/

    /*private fun getConnection(){

        Tovuti.from(this).monitor(object : Monitor.ConnectivityListener {
            override fun onConnectivityChanged(
                connectionType: Int,
                isConnected: Boolean,
                isFast: Boolean
            ) {

                if (isConnected) {
                    mainActivityViewModel.getArticlesFromServer()
                    Timber.e("connected")
                } else {
                    mainActivityViewModel.getArticlesFromLocalDb()
                    Timber.e("local")

                }
            }
        })

    }*/


    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        when (item.itemId) {
            R.id.history -> startActivity(Intent(this, HistoryActivity::class.java))
            else -> super.onOptionsItemSelected(item)
        }

        return true
    }*/
}




