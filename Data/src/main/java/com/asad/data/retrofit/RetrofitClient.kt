package com.asad.data.retrofit

import android.content.Context
import com.asad.data.utils.URLs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@InstallIn(SingletonComponent::class)
@Module
class RetrofitClient {

    private var timeOut: Long = 60

    @Provides
    fun provideBaseURL(@ApplicationContext context: Context) = URLs.baseUrl

    @Provides
    fun provideCertificates(): Array<TrustManager> {
        return arrayOf<TrustManager>(object : X509TrustManager {
            @Throws(CertificateException::class)
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        })
    }


    @Singleton
    @Provides
    fun createOkHttpClient(trustAllCerts: Array<TrustManager>): OkHttpClient {
        val protocols: MutableList<Protocol> = ArrayList()
        protocols.add(Protocol.HTTP_1_1)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, SecureRandom())

        return OkHttpClient.Builder().protocols(protocols)
            .sslSocketFactory(sslContext.socketFactory, (trustAllCerts[0] as X509TrustManager))
            .hostnameVerifier { hostname: String?, session: SSLSession? -> true }
            .readTimeout(timeOut, TimeUnit.MINUTES).connectTimeout(timeOut, TimeUnit.MINUTES)
            .writeTimeout(timeOut, TimeUnit.MINUTES).addInterceptor(interceptor)
            .addInterceptor(interceptor).addInterceptor { chain ->
                val requestBuilder: Request.Builder = chain.request().newBuilder()
                requestBuilder.addHeader("Authorization", URLs.userAccessToken)
                requestBuilder.addHeader("auth", URLs.tokenHeader)
                requestBuilder.addHeader("accept", URLs.accept)
                requestBuilder.addHeader("Content-Type", URLs.contentType)
                chain.proceed(requestBuilder.build())
            }.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(ScalarsConverterFactory.create()).client(okHttpClient).build()
    }

    @Provides
    @Singleton
    fun providesRestAPI(retrofit: Retrofit): RetrofitAPI {
        return retrofit.create(RetrofitAPI::class.java)
    }
}