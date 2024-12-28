package com.han.swm

import android.util.Log
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.navigation.navigation
import com.han.swm.common.NavigationBottomBar
import com.han.swm.common.SWMMenu
import com.han.swm.data.datastore.TokenStorage
import com.han.swm.feature.changepassword.navigation.changePasswordScreen
import com.han.swm.feature.dashboard.navigation.DashBoardRoute
import com.han.swm.feature.dashboard.navigation.dashBoardScreen
import com.han.swm.feature.auth.forgotpassword.navigation.ForgotPasswordRoute
import com.han.swm.feature.auth.forgotpassword.navigation.forgotPasswordScreen
import com.han.swm.feature.auth.forgotpassword.navigation.navigateToForgotPassword
import com.han.swm.feature.auth.login.navigation.LoginRoute
import com.han.swm.feature.auth.login.navigation.loginScreen
import com.han.swm.feature.auth.login.navigation.navigateToLogin
import com.han.swm.feature.changepassword.navigation.navigateToChangePassword
import com.han.swm.feature.dashboard.navigation.navigateToDashboard
import com.han.swm.feature.productdetail.navigation.navigateToProductDetail
import com.han.swm.feature.productdetail.navigation.productDetailScreen
import com.han.swm.feature.profile.navigation.navigateToProfileDetail
import com.han.swm.feature.profile.navigation.profileDetailScreen
import com.han.swm.feature.setting.navigation.SettingRoute
import com.han.swm.feature.setting.navigation.settingScreen
import com.han.swm.feature.shipment.navigation.ShipmentRoute
import com.han.swm.feature.shipment.navigation.shipmentScreen
import com.han.swm.feature.shipmentDetail.navigation.navigateToShipmentDetail
import com.han.swm.feature.shipmentDetail.navigation.shipmentDetailScreen
import com.han.swm.feature.stock.navigation.StockRoute
import com.han.swm.feature.stock.navigation.stockScreen
import com.han.swm.feature.updateprofile.navigation.navigateToUpdateProfile
import com.han.swm.feature.updateprofile.navigation.updateProfileScreen
import kotlinx.serialization.Serializable

interface SWMRoute

fun NavBackStackEntry?.equal(route: SWMRoute): Boolean {
    val routeName = this?.destination?.route ?: return false

    return routeName.contains(route::class.qualifiedName!!)
}

fun NavBackStackEntry?.toMenu(): SWMMenu {
    return when {
        equal(DashBoardRoute) -> SWMMenu.Home
        equal(SettingRoute) -> SWMMenu.Setting
        equal(ShipmentRoute) -> SWMMenu.Shipment
        equal(StockRoute) -> SWMMenu.Stock

        else -> SWMMenu.Home
    }
}

@Composable
fun SWMNavHost(
    modifier: Modifier = Modifier,
    startDestination: SWMRoute = LoginRoute
) {
    val navController = rememberNavController()
    val currentDes by navController.currentBackStackEntryAsState()

    LaunchedEffect(Unit) {
        if(TokenStorage.dataStore.getAccessToken() != null) {
            navController.navigateToDashboard()
        }
    }

    Scaffold(
        bottomBar = {
            if (
                currentDes.equal(DashBoardRoute)
                || currentDes.equal(SettingRoute)
                || currentDes.equal(ShipmentRoute)
                || currentDes.equal(StockRoute)
            ) {
                NavigationBottomBar(navController)
            }
        }
    ) { paddings ->
        NavHost(
            modifier = modifier.padding(paddings),
            navController = navController,
            startDestination = startDestination,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
        ) {
            loginScreen(
                onGoToForgotPassword = { email ->
                    navController.navigateToForgotPassword(
                        ForgotPasswordRoute(email = email)
                    )
                },
                onGoToDashBoard = navController::navigateToDashboard
            )
            forgotPasswordScreen(
                onNavigateBack = navController::navigateUp
            )

            mainNavHost(navController)
        }
    }
}

@Serializable
object MainNav: SWMRoute

fun NavGraphBuilder.mainNavHost(
    navController: NavController
) {
    navigation<MainNav>(startDestination = DashBoardRoute) {
        dashBoardScreen()
        settingScreen(
            onGoToChangePassword = navController::navigateToChangePassword,
            onGoToUpdateInfo = navController::navigateToUpdateProfile,
            onGoToUserInfo = navController::navigateToProfileDetail,
            onGoToActivity = {  },
            onGoToGuide = {},
            onGoToLogin = {
                navController.navigateToLogin(
                    navOptions = navOptions {
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    }
                )
            }
        )
        changePasswordScreen(
            onNavigateBack = navController::navigateUp
        )
        updateProfileScreen(onNavigateBack = navController::navigateUp)
        profileDetailScreen(onNavigateBack = navController::navigateUp)

        shipmentScreen(
            onGoToShipmentDetail = navController::navigateToShipmentDetail
        )

        shipmentDetailScreen(
            onNavigateBack = navController::navigateUp
        )
        stockScreen(
            onGoToProductDetail = navController::navigateToProductDetail
        )

        productDetailScreen (
            onBack = navController::navigateUp
        )
    }
}

