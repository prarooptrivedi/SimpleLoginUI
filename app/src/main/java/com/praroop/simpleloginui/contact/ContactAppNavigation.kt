package com.praroop.simpleloginui.contact

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.praroop.simpleloginui.otpVerification.OtpScreen
import com.praroop.simpleloginui.otpVerification.PhoneNumberScreen

@Composable
fun ContactAppNavigator(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel: ContactViewModel = viewModel()
    NavHost(navController, startDestination = "phone") {
        composable("phone") { PhoneNumberScreen(navController) }
        composable("otp/{verificationId}") {
            val verificationId = it.arguments?.getString("verificationId") ?: ""
            OtpScreen(navController, verificationId)
        }
        composable("home/{userId}") {
            val userId = it.arguments?.getString("userId") ?: ""
            com.praroop.simpleloginui.otpVerification.HomeScreen(userId)
        }
    }

//    NavHost(navController, startDestination = "home") {
//        composable("home") {
//            HomeScreen(
//                selected = viewModel.selectedContacts,
//                onClick = { navController.navigate("contacts") }
//            )
//        }
//        composable("contacts") {
//            ContactPickerScreen(
//                viewModel = viewModel,
//                onSubmit = {
//                    viewModel.saveSelected()
//                    navController.popBackStack()
//                }
//            )
//        }
//    }
}