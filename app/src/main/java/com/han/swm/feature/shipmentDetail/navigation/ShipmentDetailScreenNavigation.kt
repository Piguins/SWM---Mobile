package com.han.swm.feature.shipmentDetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.han.swm.SWMRoute
import com.han.swm.feature.auth.forgotpassword.ForgotPasswordScreenRoute
import com.han.swm.feature.auth.forgotpassword.navigation.ForgotPasswordRoute
import com.han.swm.feature.shipmentDetail.ShipmentDetailScreenRoute
import com.han.swm.feature.shipmentDetail.ShipmentDetailScreenViewModel
import kotlinx.serialization.Serializable

@Serializable
data class ShipmentDetailRoute(
    val shipmentId: Int
): SWMRoute

fun NavController.navigateToShipmentDetail(
    shipmentId: Int,
    navOptions: NavOptions? = null
) {
    this.navigate(ShipmentDetailRoute(shipmentId), navOptions)
}

fun NavGraphBuilder.shipmentDetailScreen(
    onNavigateBack: () -> Unit,
) {
    composable<ShipmentDetailRoute> {
        ShipmentDetailScreenRoute (
            onBack = onNavigateBack
        )
    }
}