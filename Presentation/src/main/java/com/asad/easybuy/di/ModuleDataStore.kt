package com.asad.easybuy.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

private val USER_PREFERENCE = "biiview"

@Module
@InstallIn(SingletonComponent::class)
object ModuleDataStore {

    @Provides
    fun providePreferenceDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(corruptionHandler = ReplaceFileCorruptionHandler(
            produceNewData = { emptyPreferences() }),
            migrations = listOf(SharedPreferencesMigration(context, USER_PREFERENCE)),
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { context.preferencesDataStoreFile(USER_PREFERENCE) })
    }
}