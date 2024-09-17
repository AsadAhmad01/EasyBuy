package com.arhamsoft.data.preferences

import com.asad.data.utils.PreferencesKeys
import com.asad.domain.repositories.RepoUserPreferencesStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceManager @Inject
constructor(private val userPreferenceRepository: RepoUserPreferencesStore) {

    fun saveToken(token: String) {
        CoroutineScope(Dispatchers.IO).launch {
            userPreferenceRepository.saveStringValueInPreference(
                PreferencesKeys.firebaseToken,
                token
            )
        }
    }
}