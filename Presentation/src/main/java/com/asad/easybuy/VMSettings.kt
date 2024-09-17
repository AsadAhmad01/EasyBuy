package com.asad.easybuy

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asad.domain.models.MDSettings
import com.asad.domain.repositories.RepoUserPreferencesStore
import com.asad.domain.repositories.RepositorySettings
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VMSettings @Inject constructor(
    private val appContext: Context,
    private val repository: RepositorySettings,
    private val userPref: RepoUserPreferencesStore
) : ViewModel() {

    // Data Init
    private val _settingsData = MutableLiveData<MDSettings>()
    var settingsData: LiveData<MDSettings> = _settingsData


    // States Init
    var errorMsg = MutableLiveData<String>()
    var isLoading = MutableLiveData(false)


    // API calls
    fun callSettings(data: JsonObject) {
//        viewModelScope.launch {
//            repository.setSettings(data).catch {
//                isLoading.value = false
//                errorMsg.value = it.message
//            }.collect {
//                isLoading.value = false
//                if (it.body()!!.status!!) {
//                    Log.e("SETTINGS RESPONSE", "callSettings: ${it.body()!!.data}")
//                    _settingsData.postValue(it.body())
//                } else {
//                    errorMsg.value = it.body()!!.message
//                }
//
//            }
//        }
    }

}