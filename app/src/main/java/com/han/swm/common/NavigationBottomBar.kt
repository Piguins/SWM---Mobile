package com.han.swm.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationBottomBar(
    navController: NavController
) {
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar {
        SWMMenu.entries.forEachIndexed { index, menu ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    when (menu) {
                        SWMMenu.Home -> {}
                        SWMMenu.Product -> {}
                        SWMMenu.Shipment -> {}
                        SWMMenu.Profile -> {}
                    }
                },
                icon = {
                    Icon(Icons.Default.Home, contentDescription = "")
                },
                label = {}
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

