package com.example.kotlinstarter.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinstarter.repositories.MainActivityRepository
import com.example.kotlinstarter.utils.Done
import com.example.kotlinstarter.utils.Loading
import com.example.kotlinstarter.utils.ViewState
import kotlinx.coroutines.launch

class HistoryActivityViewModel @ViewModelInject constructor(
    private val mainActivityRepository: MainActivityRepository
): ViewModel() {

    private  var _viewStates = MutableLiveData<ViewState>()

    val viewState: LiveData<ViewState>
        get() = _viewStates

    private var _previousLiveData = MutableLiveData<List<PreviousDocs>>()

    val previousLiveData: LiveData<List<PreviousDocs>>
        get() = _previousLiveData


    fun getPreviousArticles(){
        viewModelScope.launch {
            _viewStates.value = Loading()
            _previousLiveData.value =  mainActivityRepository.getPreviousDataFromLocal()
            _viewStates.value = Done()

        }
    }

}