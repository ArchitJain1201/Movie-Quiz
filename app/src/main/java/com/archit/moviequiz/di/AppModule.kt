package com.archit.moviequiz.di

import android.app.Application
import androidx.room.Room
import com.archit.moviequiz.data.local.QuizDatabase
import com.archit.moviequiz.data.remote.QuizApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideStockApi(): QuizApi {
        return Retrofit.Builder()
            .baseUrl(QuizApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }).build())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideStockDatabase(app: Application): QuizDatabase {
        return Room.databaseBuilder(
            app,
            QuizDatabase::class.java,
            "quizdb.db"
        ).build()
    }
}