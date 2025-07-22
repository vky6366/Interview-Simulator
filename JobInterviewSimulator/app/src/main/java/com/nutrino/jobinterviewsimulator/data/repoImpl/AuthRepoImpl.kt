package com.nutrino.jobinterviewsimulator.data.repoImpl

import com.google.firebase.auth.FirebaseAuth
import com.nutrino.jobinterviewsimulator.data.ResultState.ResultState
import com.nutrino.jobinterviewsimulator.domain.repository.AuthRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(private val firebaseAuth: FirebaseAuth): AuthRepository {
    override suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<ResultState<String>> = callbackFlow{
        trySend(ResultState.Loading)
        try {
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                trySend(ResultState.Success("SignUp Successfully"))
            }.addOnFailureListener {result->
                trySend(ResultState.Error("Failure in SignUp"))
            }
            awaitClose {
                close()
            }
        }catch (e: Exception){
            trySend(ResultState.Error("Failure in SignUp"))
        }

    }


}