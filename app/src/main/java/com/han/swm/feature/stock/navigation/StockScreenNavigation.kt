package com.han.swm.feature.stock.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.han.swm.SWMRoute
import com.han.swm.feature.dashboard.DashBoardScreenRoute
import com.han.swm.feature.dashboard.navigation.DashBoardRoute
import com.han.swm.feature.stock.StockScreenRoute
import kotlinx.serialization.Serializable

@Serializable
object StockRoute: SWMRoute

fun NavController.navigateToStock(navOptions: NavOptions? = null) {
    this.navigate(StockRoute, navOptions)
}

fun NavGraphBuilder.stockScreen(
    onGoToProductDetail: (Int) -> Unit,
) {
    composable<StockRoute> {
        StockScreenRoute(
            onGoToProductDetail = onGoToProductDetail
        )
    }
}