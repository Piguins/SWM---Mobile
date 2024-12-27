package com.han.swm.feature.productdetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.han.swm.SWMRoute
import com.han.swm.feature.dashboard.DashBoardScreenRoute
import com.han.swm.feature.auth.login.LoginScreenRoute
import com.han.swm.feature.auth.login.navigation.LoginRoute
import com.han.swm.feature.dashboard.navigation.DashBoardRoute
import com.han.swm.feature.productdetail.ProductDetailScreenRoute
import kotlinx.serialization.Serializable

@Serializable
data class ProductDetailRoute(
    val id: Int
): SWMRoute

fun NavController.navigateToProductDetail(id: Int, navOptions: NavOptions? = null) {
    this.navigate(ProductDetailRoute(id), navOptions)
}

fun NavGraphBuilder.productDetailScreen(
    onBack: () -> Unit
) {
    composable<ProductDetailRoute> {
        ProductDetailScreenRoute(
            onBack = onBack
        )
    }
}