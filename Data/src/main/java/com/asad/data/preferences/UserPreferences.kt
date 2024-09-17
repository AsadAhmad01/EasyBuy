package com.asad.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.asad.data.utils.PreferencesKeys.USER_PREFERENCES_NAME
import kotlinx.coroutines.flow.map

private val Context.datastore: DataStore<Preferences> by preferencesDataStore(
    USER_PREFERENCES_NAME
)

class UserPreferences(private val context: Context) {

    suspend fun saveStringValueInPreference(key: Preferences.Key<String>, value: String) {
        context.datastore.edit { pref ->
            pref[key] = value
        }
    }

    suspend fun saveBooleanValueInPreference(key: Preferences.Key<Boolean>, value: Boolean) {
        context.datastore.edit { pref ->
            pref[key] = value
        }
    }

    suspend fun saveIntValueInPreference(key: Preferences.Key<Int>, value: Int) {
        context.datastore.edit { pref ->
            pref[key] = value
        }
    }


    suspend fun getStringValueFromPreference(key: Preferences.Key<String>) {
        context.datastore.data.map { pref ->
            pref[key] ?: ""
        }
    }

    suspend fun getBooleanValueFromPreference(key: Preferences.Key<Boolean>) {
        context.datastore.data.map { pref ->
            pref[key] ?: ""
        }
    }

    suspend fun getIntValueFromPreference(key: Preferences.Key<Int>) {
        context.datastore.data.map { pref ->
            pref[key] ?: ""
        }
    }

}