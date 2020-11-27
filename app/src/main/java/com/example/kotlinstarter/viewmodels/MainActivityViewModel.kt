package com.example.kotlinstarter.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinstarter.models.Doc
import com.example.kotlinstarter.repositories.MainActivityRepository
import com.example.kotlinstarter.utils.Done
import com.example.kotlinstarter.utils.Loading
import com.example.kotlinstarter.utils.ViewState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityViewModel @ViewModelInject constructor(
    private val mainActivityRepository: MainActivityRepository,
) : ViewModel() {


    private var _viewStates = MutableLiveData<ViewState>()

    val viewState: LiveData<ViewState>
        get() = _viewStates

    private var _dnaLiveData = MutableLiveData<List<Doc>>()

    val dnaLiveData: LiveData<List<Doc>>
        get() = _dnaLiveData

    private var _queryString = MutableLiveData<String>()

    val queryString: LiveData<String>
        get() = _queryString


    fun getArticlesFromServer() {

        viewModelScope.launch {
            _viewStates.value = Loading()
            _dnaLiveData.value =
                mainActivityRepository.getDnaFromServerAndSave("title:${queryString.value}")
            _viewStates.value = Done()
        }
    }

    fun getArticlesFromLocalDb() {

        viewModelScope.launch {
            _viewStates.value = Loading()
            _dnaLiveData.value = mainActivityRepository.getDataFromLocal()
            _viewStates.value = Done()
        }
    }


    fun updateQueryString(queryString: String) {
        _queryString.value = queryString

    }

     fun deleteAllSearches() {
        //clear searched
            mainActivityRepository.deleteSearch()

    }
}
