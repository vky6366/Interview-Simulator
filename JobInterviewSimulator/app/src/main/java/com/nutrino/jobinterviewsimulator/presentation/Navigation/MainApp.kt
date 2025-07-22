package com.nutrino.jobinterviewsimulator.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nutrino.jobinterviewsimulator.presentation.Screens.LoginScreen
import com.nutrino.jobinterviewsimulator.presentation.Screens.ResumeUploadScreen
import com.nutrino.jobinterviewsimulator.presentation.Screens.SignUPScreen

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(navController =  navController , startDestination = LOGINSCREEN){
        composable<LOGINSCREEN> {
            LoginScreen(navController = navController)
        }
        composable<SIGNUPSCREEN> {
            SignUPScreen(navController = navController)
        }
        composable<RESUMEUPLOADSCREEN> {
            ResumeUploadScreen(navController= navController)

        }

    }

}