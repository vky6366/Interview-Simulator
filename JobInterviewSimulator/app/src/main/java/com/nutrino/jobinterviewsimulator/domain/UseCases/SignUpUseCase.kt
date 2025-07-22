package com.nutrino.jobinterviewsimulator.domain.UseCases

import com.nutrino.jobinterviewsimulator.data.ResultState.ResultState
import com.nutrino.jobinterviewsimulator.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String , password: String): Flow<ResultState<String>>{
        return repository.signUpWithEmailAndPassword(email = email, password = password)
    }
}