package com.han.swm.feature.dashboard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.han.swm.SWMRoute
import com.han.swm.feature.dashboard.DashBoardScreenRoute
import com.han.swm.feature.auth.login.LoginScreenRoute
import com.han.swm.feature.auth.login.navigation.LoginRoute
import kotlinx.serialization.Serializable

@Serializable
object DashBoardRoute: SWMRoute

fun NavController.navigateToDashboard(navOptions: NavOptions? = null) {
    this.navigate(DashBoardRoute, navOptions)
}

fun NavGraphBuilder.dashBoardScreen() {
    composable<DashBoardRoute> {
        DashBoardScreenRoute()
    }
}