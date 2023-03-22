package com.app.instaimage.di

import android.content.Context
import androidx.room.Room
import com.app.instaimage.common.*
import com.app.instaimage.BuildConfig
import com.app.instaimage.api.PixaBayApi
import com.app.instaimage.dao.ImageDao
import com.app.instaimage.db.PixaBayRoomDb
import com.app.instaimage.repository.SearchImagesRepositoryImpl
import com.app.instaimage.repository.SearchImagesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Hilt Module, used to provide dependencies
 */
@Module
@InstallIn(SingletonComponent::class)
object Module {
    private val loggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(apiInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) okHttpClient.addInterceptor(loggingInterceptor)
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providesApi(retrofit: Retrofit): PixaBayApi = retrofit.create(PixaBayApi::class.java)

    @Provides
    @Singleton
    fun providesRepository(
        pixaBayApi: PixaBayApi,
        pixaBayRoomDb: PixaBayRoomDb,
    ): SearchImagesRepository = SearchImagesRepositoryImpl(pixaBayApi, pixaBayRoomDb)


    private val apiInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(KEY.first, KEY.second)
            .addQueryParameter(IMAGE_TYPE.first, IMAGE_TYPE.second)
            .build()
        request.url(url)
        chain.proceed(request.build())
    }

    @Singleton
    @Provides
    fun providesPixaBayRoomDb(@ApplicationContext appContext: Context): PixaBayRoomDb {
        return Room.databaseBuilder(
            appContext,
            PixaBayRoomDb::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration().build()
    }


    @Singleton
    @Provides
    fun providesImageDao(pixaBayRoomDb: PixaBayRoomDb): ImageDao {
        return pixaBayRoomDb.imageDao()
    }


}