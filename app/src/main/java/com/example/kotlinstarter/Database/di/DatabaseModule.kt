package com.example.kotlinstarter.Database.di

import android.content.Context
import androidx.room.Room
import com.example.kotlinstarter.Database.base.AppDatabase
import com.example.kotlinstarter.Database.Dao.ArticleDao
import com.example.kotlinstarter.Database.Dao.PreviousDocsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideChannelDao(appDatabase: AppDatabase): ArticleDao {
        return appDatabase.articleDao()
    }

    @Provides
    fun providePreviousDocsDao(appDatabase: AppDatabase): PreviousDocsDao {
        return appDatabase.previousDocsDao()
    }


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "ArticlesDatabase"
        ).build()
    }
}