package com.asad.domain.repositories

import com.asad.domain.models.MDSettings
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RepositorySettings {

    suspend fun setSettings(data: JsonObject): Flow<Response<MDSettings>>
}