package com.example.kotlinstarter.viewmodels


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinstarter.mappers.toPresenter
import com.example.kotlinstarter.models.DocPresenter
import com.example.kotlinstarter.models.states.Error
import com.example.kotlinstarter.models.states.MainActivityArticleViewState
import com.sammy.domain.usecases.ArticleBaseUseCase
import com.sammy.domain.usecases.ArticleUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val articleUseCase: ArticleBaseUseCase
) : BaseViewModel() {
    private var getArticleJob: Job? = null
    val articleViewState: LiveData<MainActivityArticleViewState>
        get() = _articleViewState

    private var _articleViewState = MutableLiveData<MainActivityArticleViewState>()

    init {
        _articleViewState.value =
            MainActivityArticleViewState(
                isLoading = false,
                error = null,
                articleResults = null
            )
    }

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        val message = exception.message.toString()
        onGetArticleError(message)
    }

    private fun onGetArticleError(message: String) {
        _articleViewState.value = _articleViewState.value?.copy(isLoading = false,error = com.example.kotlinstarter.models.states.Error(message))
    }

    override fun onCleared() {
        super.onCleared()
        getArticleJob?.cancel()
    }
    fun executeGetArticles(search:String){
        getArticleJob?.cancel()
        getArticleJob = launchCoroutine {
            delay(500)
            onGetArticleLoading()
            articleUseCase(search).collect {
                val searchResult = it.map { docDomain -> docDomain.toPresenter() }
                onCompleteGetArticles(searchResult)
                Log.d("MainActivityViewModel","***************RESULTS******=>${searchResult}")

            }
        }
    }

    private fun onCompleteGetArticles(searchResult: List<DocPresenter>){
        _articleViewState.value = _articleViewState.value?.copy(isLoading = false,articleResults = searchResult)
    }


    private fun onGetArticleLoading() {
        _articleViewState.value = _articleViewState.value?.copy(isLoading = true)
    }
}
