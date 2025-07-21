package com.nutrino.jobinterviewsimulator.domain.repository

interface AuthRepository {
    suspend fun signUpWithEmailAndPassword(email: String, password: String)
}