package com.archit.moviequiz.di

import com.archit.moviequiz.data.repository.QuizRepositoryImpl
import com.archit.moviequiz.domain.repostiory.QuizRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindQuizRepository(
        quizRepositoryImpl: QuizRepositoryImpl
    ):  QuizRepository
}