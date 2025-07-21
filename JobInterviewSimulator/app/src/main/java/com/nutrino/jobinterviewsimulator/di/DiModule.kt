package com.nutrino.jobinterviewsimulator.di

import com.google.firebase.auth.FirebaseAuth
import com.nutrino.jobinterviewsimulator.data.repoImpl.AuthRepoImpl
import com.nutrino.jobinterviewsimulator.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DiModule {
    @Provides
    fun authrepoObj(): AuthRepository{
        return AuthRepoImpl()
    }

    @Provides
    fun firebaseAuth(): FirebaseAuth{
        return FirebaseAuth.getInstance()
    }
}