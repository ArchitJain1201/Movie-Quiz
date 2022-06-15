package com.archit.moviequiz.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.archit.moviequiz.data.local.QuizDatabase
import com.archit.moviequiz.data.remote.QuizApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.requestly.rqinterceptor.api.RQCollector
import io.requestly.rqinterceptor.api.RQInterceptor
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
    fun provideQuizApi(@ApplicationContext appContext: Context): QuizApi {
        val collector = RQCollector(context = appContext, sdkKey="OiVlATaJTR8oPPJmhx2e")
        val rqInterceptor = RQInterceptor.Builder( appContext ).collector(collector).build()
        return Retrofit.Builder()
            .baseUrl(QuizApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor(rqInterceptor).build())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideQuizDatabase(app: Application): QuizDatabase {
        return Room.databaseBuilder(
            app,
            QuizDatabase::class.java,
            "quizdb.db"
        ).build()
    }
}