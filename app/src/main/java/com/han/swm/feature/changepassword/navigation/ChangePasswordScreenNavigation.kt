package com.han.swm.feature.changepassword.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.han.swm.SWMRoute
import com.han.swm.feature.changepassword.ChangePasswordScreenRoute
import com.han.swm.feature.auth.login.LoginScreenRoute
import com.han.swm.feature.auth.login.navigation.LoginRoute
import kotlinx.serialization.Serializable

@Serializable
object ChangePasswordRoute: SWMRoute

fun NavController.navigateToChangePassword(navOptions: NavOptions? = null) {
    this.navigate(ChangePasswordRoute, navOptions)
}

fun NavGraphBuilder.changePasswordScreen(
    onNavigateBack: () -> Unit
) {
    composable<ChangePasswordRoute> {
        ChangePasswordScreenRoute(
            onNavigateBack = onNavigateBack
        )
    }
}