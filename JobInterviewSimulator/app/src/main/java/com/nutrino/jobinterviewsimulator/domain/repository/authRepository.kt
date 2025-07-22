package com.nutrino.jobinterviewsimulator.domain.repository

import com.nutrino.jobinterviewsimulator.data.ResultState.ResultState
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun signUpWithEmailAndPassword(email: String, password: String): Flow<ResultState<String>>
}