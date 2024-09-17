package com.asad.domain.repositories

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface RepoUserPreferencesStore {
    suspend fun getStringValueFromPreference(key: Preferences.Key<String>): Flow<String>

    suspend fun getIntegerValueFromPreference(key: Preferences.Key<Int>): Flow<Int>

    suspend fun getBooleanValueFromPreference(key: Preferences.Key<Boolean>): Flow<Boolean>

    suspend fun saveStringValueInPreference(key: Preferences.Key<String>, value: String)

    suspend fun saveIntValueInPreference(key: Preferences.Key<Int>, value: Int)

    suspend fun saveBooleanValueInPreference(key: Preferences.Key<Boolean>, value: Boolean)

    suspend fun clearPreference()

    suspend fun removeKeyFromPreference(key: Preferences.Key<String>)
}