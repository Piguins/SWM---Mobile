package com.han.swm.feature.forgotpassword.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.han.swm.SWMRoute
import com.han.swm.feature.forgotpassword.ForgotPasswordScreenRoute
import com.han.swm.feature.login.LoginScreenRoute
import kotlinx.serialization.Serializable

const val emailArg = "email"

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