package com.han.swm.feature.auth.forgotpassword.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.han.swm.SWMRoute
import com.han.swm.feature.auth.forgotpassword.ForgotPasswordScreenRoute
import com.han.swm.feature.auth.login.LoginScreenRoute
import kotlinx.serialization.Serializable

@Serializable
data class ForgotPasswordRoute(
    val email: String
): SWMRoute

fun NavController.navigateToForgotPassword(
    forgotPasswordRoute: ForgotPasswordRoute,
    navOptions: NavOptions? = null
) {
    this.navigate(forgotPasswordRoute, navOptions)
}

fun NavGraphBuilder.forgotPasswordScreen(
    onNavigateBack: () -> Unit,
) {
    composable<ForgotPasswordRoute> {
        ForgotPasswordScreenRoute(
            onNavigateBack = onNavigateBack
        )
    }
}