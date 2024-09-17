package com.asad.data.repositoryImplementations

import com.asad.data.retrofit.RetrofitAPI
import com.asad.domain.models.MDSettings
import com.asad.domain.repositories.RepositorySettings
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class RepoImpSettings @Inject constructor(private val api: RetrofitAPI) : RepositorySettings {
    override suspend fun setSettings(data: JsonObject): Flow<Response<MDSettings>> {
        return flow {
            emit(api.getSettings(data))
        }
    }
}