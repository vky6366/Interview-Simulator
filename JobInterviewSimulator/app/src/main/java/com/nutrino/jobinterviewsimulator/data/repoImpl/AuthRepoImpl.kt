package com.nutrino.jobinterviewsimulator.data.repoImpl

import com.nutrino.jobinterviewsimulator.domain.repository.AuthRepository

class AuthRepoImpl: AuthRepository {
    override suspend fun signUpWithEmailAndPassword(email: String, password: String) {
        TODO("Not yet implemented")
    }

}