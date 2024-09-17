package com.asad.data.repositoryImplementations

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.asad.data.utils.PreferencesKeys
import com.asad.domain.repositories.RepoUserPreferencesStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = PreferencesKeys.USER_PREFERENCES_NAME
)

class RepoImpUserPreferences @Inject constructor(private val context: Context) :
    RepoUserPreferencesStore {

    override suspend fun getStringValueFromPreference(key: Preferences.Key<String>): Flow<String> {
        return context.dataStore.data.catch { emit(emptyPreferences()) }.map { pref ->
            pref[key] ?: ""
        }
    }

    override suspend fun getIntegerValueFromPreference(key: Preferences.Key<Int>): Flow<Int> {
        return context.dataStore.data.catch { emit(emptyPreferences()) }.map { pref ->
            pref[key] ?: 0
        }
    }

    override suspend fun getBooleanValueFromPreference(key: Preferences.Key<Boolean>): Flow<Boolean> {
        return context.dataStore.data.catch { emit(emptyPreferences()) }.map { pref ->
            pref[key] ?: false
        }
    }

    override suspend fun saveStringValueInPreference(key: Preferences.Key<String>, value: String) {
        context.dataStore.edit { pref ->
            pref[key] = value
        }
    }

    override suspend fun saveIntValueInPreference(key: Preferences.Key<Int>, value: Int) {
        context.dataStore.edit { pref ->
            pref[key] = value
        }
    }

    override suspend fun saveBooleanValueInPreference(
        key: Preferences.Key<Boolean>, value: Boolean
    ) {
        context.dataStore.edit { pref ->
            pref[key] = value
        }
    }

    override suspend fun clearPreference() {
        context.dataStore.edit { pref ->
            pref.clear()
        }
    }

    override suspend fun removeKeyFromPreference(key: Preferences.Key<String>) {
        context.dataStore.edit { pref ->
            if (pref.contains(key)) pref.remove(key)
        }
    }
}