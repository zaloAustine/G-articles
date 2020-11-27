package com.example.kotlinstarter.repositories

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.example.kotlinstarter.Database.Dao.ArticleDao
import com.example.kotlinstarter.Database.Dao.PreviousDocsDao
import com.example.kotlinstarter.mappers.toPreviousDoc
import com.example.kotlinstarter.models.Doc
import com.example.kotlinstarter.models.PreviousDocs
import com.example.kotlinstarter.services.MainActivityApiService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


class MainActivityRepository @Inject constructor(
    @Named("foodApi") private val mainActivityApiService: MainActivityApiService,
    private val articleDao: ArticleDao,
    private val previousDocsDao: PreviousDocsDao,
    @ApplicationContext private val context: Context
){

    suspend fun getDataFromLocal():List<Doc>{
        return articleDao.getArticles()
    }

    suspend fun getPreviousDataFromLocal():List<PreviousDocs>{
        return previousDocsDao.getPreviousArticles()
    }

          fun deleteSearch(){
             GlobalScope.launch {
                 articleDao.deleteArticles()
             }
    }

      suspend fun getDnaFromServerAndSave(title: String):List<Doc> {
          var articles: List<Doc>? = null
          articles = mainActivityApiService.getDna(title).await().response?.docs

          if(!articles.isNullOrEmpty()){
              val listDocs = arrayListOf(articles.toPreviousDoc())
              articleDao.insertAllArticles(articles)
              previousDocsDao.insertAllPreviousArticles(listDocs)
          }

          return articles!!
      }

    }



