package com.asad.easybuy.di

import android.content.Context
import com.asad.data.repositoryImplementations.RepoImpSettings
import com.asad.data.repositoryImplementations.RepoImpUserPreferences
import com.asad.data.retrofit.RetrofitAPI
import com.asad.domain.repositories.RepoUserPreferencesStore
import com.asad.domain.repositories.RepositorySettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleNetwork {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context


    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): RepoUserPreferencesStore {
        return RepoImpUserPreferences(context)
    }

    @Provides
    @Singleton
    fun provideSettingsImp(api: RetrofitAPI): RepositorySettings {
        return RepoImpSettings(api)
    }

}