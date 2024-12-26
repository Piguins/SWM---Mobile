package com.han.swm.feature.updateprofile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.han.swm.SWMRoute
import com.han.swm.feature.changepassword.ChangePasswordScreenRoute
import com.han.swm.feature.updateprofile.UpdateProfileScreenRoute
import kotlinx.serialization.Serializable

@Serializable
object UpdateProfileRoute: SWMRoute

fun NavController.navigateToUpdateProfile(navOptions: NavOptions? = null) {
    this.navigate(UpdateProfileRoute, navOptions)
}

fun NavGraphBuilder.updateProfileScreen(
    onNavigateBack: () -> Unit
) {
    composable<UpdateProfileRoute> {
        UpdateProfileScreenRoute (
            onBack = onNavigateBack
        )
    }
}