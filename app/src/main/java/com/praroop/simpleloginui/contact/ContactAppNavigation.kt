package com.praroop.simpleloginui.contact

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ContactAppNavigator(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel: ContactViewModel = viewModel()

    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                selected = viewModel.selectedContacts,
                onClick = { navController.navigate("contacts") }
            )
        }
        composable("contacts") {
            ContactPickerScreen(
                viewModel = viewModel,
                onSubmit = {
                    viewModel.saveSelected()
                    navController.popBackStack()
                }
            )
        }
    }
}