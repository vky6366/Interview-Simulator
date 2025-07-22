package com.nutrino.jobinterviewsimulator.presentation.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nutrino.jobinterviewsimulator.data.ResultState.ResultState
import com.nutrino.jobinterviewsimulator.domain.UseCases.SignUpUseCase
import com.nutrino.jobinterviewsimulator.presentation.Intent.AuthIntent
import com.nutrino.jobinterviewsimulator.presentation.StateHandeling.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val signUpUseCase: SignUpUseCase) : ViewModel(){
    private val _signUpState = MutableStateFlow(SignUpState())
    val signUpState = _signUpState.asStateFlow()

    fun authIntent(intent: AuthIntent, email: String, password: String){
        when(intent){
            AuthIntent.SIGNUPINTENT->{
                signUp(email = email , password = password)
            }

        }
    }

    fun signUp(email: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            signUpUseCase.invoke(email = email, password = password).collectLatest {resultState ->
                when(resultState){
                    is ResultState.Loading -> {
                        _signUpState.value = SignUpState(isLoading = true)
                    }
                    is ResultState.Error -> {
                        _signUpState.value = SignUpState(isLoading = false, error = resultState.message)

                    }
                    is ResultState.Success -> {
                        _signUpState.value= SignUpState(isLoading = false, data = resultState.data)
                    }

                }

            }
        }

    }

}