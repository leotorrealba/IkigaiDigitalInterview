package com.leotorrealba.ikigaidigitalinterview.di

import com.leotorrealba.ikigaidigitalinterview.data.repository.ApiService
import com.leotorrealba.ikigaidigitalinterview.data.repository.DataRepositoryImpl
import com.leotorrealba.ikigaidigitalinterview.domain.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val route: String = "https://varunv.xyz/api/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(route)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDataRepository(apiService: ApiService): DataRepository {
        return DataRepositoryImpl(apiService)
    }

}