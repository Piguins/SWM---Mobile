package com.han.swm.feature.profile.navigation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.han.swm.SWMRoute
import com.han.swm.feature.profile.ProfileDetailScreenRoute
import com.han.swm.feature.updateprofile.UpdateProfileScreenRoute
import com.han.swm.feature.updateprofile.navigation.UpdateProfileRoute
import kotlinx.serialization.Serializable

@Serializable
object ProfileDetailRoute: SWMRoute

fun NavController.navigateToProfileDetail(navOptions: NavOptions? = null) {
    this.navigate(ProfileDetailRoute, navOptions)
}

fun NavGraphBuilder.profileDetailScreen(
    onNavigateBack: () -> Unit
) {
    composable<ProfileDetailRoute> {
        ProfileDetailScreenRoute (
            onBack = onNavigateBack
        )
    }
}