package com.han.swm.feature.shipment.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.han.swm.SWMRoute
import com.han.swm.feature.setting.SettingScreenRoute
import com.han.swm.feature.setting.navigation.SettingRoute
import com.han.swm.feature.shipment.ShipmentScreenRoute
import kotlinx.serialization.Serializable

@Serializable
object ShipmentRoute: SWMRoute

fun NavController.navigateToShipment(navOptions: NavOptions? = null) {
    this.navigate(ShipmentRoute, navOptions)
}

fun NavGraphBuilder.shipmentScreen(
    onGoToShipmentDetail: (id: Int) -> Unit,
) {
    composable<ShipmentRoute> {
        ShipmentScreenRoute (
            onGoToShipmentDetail = onGoToShipmentDetail
        )
    }
}