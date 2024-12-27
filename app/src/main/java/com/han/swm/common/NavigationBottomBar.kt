package com.han.swm.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.han.swm.R
import com.han.swm.feature.dashboard.navigation.navigateToDashboard
import com.han.swm.feature.setting.navigation.navigateToSetting
import com.han.swm.feature.shipment.navigation.navigateToShipment
import com.han.swm.feature.stock.navigation.navigateToStock
import com.han.swm.toMenu

@Composable
fun NavigationBottomBar(
    navController: NavHostController
) {
    val currentDes by navController.currentBackStackEntryAsState()

    var selectedMenu: SWMMenu by remember(currentDes) {
        mutableStateOf(currentDes.toMenu())
    }

    NavigationBar(
        containerColor = Color.Transparent,
        modifier = Modifier.clip(
            RoundedCornerShape(
                topStart = 12.dp,
                topEnd = 12.dp
            )
        )
    ) {
        SWMMenu.entries.forEach { menu ->
            NavigationBarItem(
                selected = selectedMenu == menu,
                onClick = {
                    selectedMenu = menu
                    when (menu) {
                        SWMMenu.Home -> navController.navigateToDashboard()
                        SWMMenu.Stock -> navController.navigateToStock()
                        SWMMenu.Shipment -> navController.navigateToShipment()
                        SWMMenu.Setting -> navController.navigateToSetting()
                    }
                },
                icon = {
                    val iconId = when (menu) {
                        SWMMenu.Home -> R.drawable.ic_menu_home
                        SWMMenu.Stock -> R.drawable.ic_menu_product
                        SWMMenu.Shipment -> R.drawable.ic_menu_chart
                        SWMMenu.Setting -> R.drawable.ic_person
                    }

                    Row (
                        modifier = Modifier.padding(vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            contentDescription = "",
                            painter = painterResource(iconId)
                        )
                    }

                },
                label = {
                    val text = when (menu) {
                        SWMMenu.Home -> "Home"
                        SWMMenu.Stock -> "Stock"
                        SWMMenu.Shipment -> "Shipment"
                        SWMMenu.Setting -> "Profile"
                    }
                    Text(text)
                }
            )
        }
    }

}

@Preview
@Composable
private fun NavigationBarPreview() {
    Surface {
        NavigationBottomBar(
            navController = rememberNavController()
        )
    }
}

