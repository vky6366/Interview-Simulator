package com.nutrino.jobinterviewsimulator.presentation.StateHandeling

data class SignUpState(
    val isLoading: Boolean = false,
    val data: String ="",
    val error: String =""
)

data class LogInState(
    val isLoading: Boolean = false,
    val data: String ="",
    val error: String =""
)