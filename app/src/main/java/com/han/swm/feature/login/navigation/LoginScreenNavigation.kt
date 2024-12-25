package com.han.swm.feature.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.han.swm.SWMRoute
import com.han.swm.feature.login.LoginScreenRoute
import kotlinx.serialization.Serializable

@Serializable
object LoginRoute: SWMRoute

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(LoginRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(
    onGoToForgotPassword: (String) -> Unit,
) {
    composable<LoginRoute> {
        LoginScreenRoute(
            onGoToForgotPassword = onGoToForgotPassword
        )
    }
}