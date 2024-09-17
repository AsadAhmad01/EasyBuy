package com.asad.data.retrofit

import com.asad.data.utils.URLs
import com.asad.domain.models.MDSettings
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitAPI {

    @POST(URLs.getSettings)
    suspend fun getSettings(
        @Body data: JsonObject
    ): Response<MDSettings>

}