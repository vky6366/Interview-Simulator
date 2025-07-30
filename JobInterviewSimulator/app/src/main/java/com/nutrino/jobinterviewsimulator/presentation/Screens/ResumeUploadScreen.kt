package com.nutrino.jobinterviewsimulator.presentation.Screens

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ResumeUploadScreen(navController: NavController) {
    Column(  modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF121417)) ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("Upload Resume here",color = Color(0xFFB0B0B0), fontSize = 32.sp)
        val pickDocLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.OpenDocument(),
            onResult = { uri ->
                if (uri != null) {
                    // Do something with the selected file URI
                    Log.d("PickedDoc", "File Uri: $uri")
                }
            }
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            pickDocLauncher.launch(arrayOf("application/pdf", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"))
        } ,colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D80F2)),
            modifier = Modifier
                .fillMaxWidth(0.80f)
                .height(52.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Pick Document")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {

        } ,colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D80F2)),
            modifier = Modifier
                .fillMaxWidth(0.80f)
                .height(52.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Upload Resume")
        }

    }
}