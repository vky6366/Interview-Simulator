package com.nutrino.jobinterviewsimulator.presentation.Intent

sealed interface AuthIntent{
    data class signUpIntent(val email: String , val password: String)
}