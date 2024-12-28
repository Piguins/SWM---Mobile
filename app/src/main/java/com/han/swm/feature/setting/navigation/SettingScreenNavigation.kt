package com.han.swm.feature.setting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.han.swm.SWMRoute
import com.han.swm.feature.setting.SettingScreenRoute
import kotlinx.serialization.Serializable

@Serializable
object SettingRoute: SWMRoute

fun NavController.navigateToSetting(navOptions: NavOptions? = null) {
    this.navigate(SettingRoute, navOptions)
}

fun NavGraphBuilder.settingScreen(
    onGoToChangePassword: () -> Unit,
    onGoToUpdateInfo: () -> Unit,
    onGoToUserInfo: () -> Unit,
    onGoToActivity: () -> Unit,
    onGoToGuide: () -> Unit,
    onGoToLogin: () -> Unit,
) {
    composable<SettingRoute> {
        SettingScreenRoute(
            onGoToChangePassword = onGoToChangePassword,
            onGoToUpdateInfo = onGoToUpdateInfo,
            onGoToUserInfo = onGoToUserInfo,
            onGoToActivity = onGoToActivity,
            onGoToGuide = onGoToGuide,
            onGoToLogin = onGoToLogin
        )
    }
}