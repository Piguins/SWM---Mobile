package com.han.swm

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.han.swm.common.NavigationBottomBar
import com.han.swm.feature.dashboard.DashBoardScreenRoute
import com.han.swm.feature.dashboard.navigation.DashBoardRoute
import com.han.swm.feature.forgotpassword.navigation.ForgotPasswordRoute
import com.han.swm.feature.forgotpassword.navigation.forgotPasswordScreen
import com.han.swm.feature.forgotpassword.navigation.navigateToForgotPassword
import com.han.swm.feature.login.navigation.LoginRoute
import com.han.swm.feature.login.navigation.loginScreen
import kotlinx.serialization.Serializable

interface SWMRoute

@Composable
fun SWMNavHost(
    modifier: Modifier = Modifier,
    startDestination: SWMRoute = MainNav
) {
    val navController = rememberNavController()
    val currentDes by navController.currentBackStackEntryAsState()
    LaunchedEffect(currentDes) {
        Log.d("HanDebug", "SWMNavHost: ${currentDes?.destination?.route}")
        Log.d("HanDebug", "SWMNavHost: ${LoginRoute::class.qualifiedName}")
    }
    Scaffold(
        bottomBar = {
            if (currentDes?.destination?.route?.contains(LoginRoute::class.qualifiedName!!) == false && currentDes?.destination?.route?.contains(ForgotPasswordRoute::class.qualifiedName!!) == false
            ) {
                NavigationBottomBar(navController)
            }
        }
    ) { paddings ->
        NavHost(
            modifier = modifier.padding(paddings),
            navController = navController,
            startDestination = startDestination
        ) {
            loginScreen(
                onGoToForgotPassword = { email ->
                    navController.navigateToForgotPassword(
                        ForgotPasswordRoute(email = email)
                    )
                }
            )
            forgotPasswordScreen(
                onNavigateBack = navController::navigateUp
            )

            mainNavHost()
        }
    }
}

@Serializable
object MainNav: SWMRoute

fun NavGraphBuilder.mainNavHost() {
    navigation<MainNav>(startDestination = DashBoardRoute) {
        composable<DashBoardRoute> {
            DashBoardScreenRoute()
        }

    }
}

