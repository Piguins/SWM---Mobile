package com.han.swm.feature.shipment

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.han.swm.R
import com.han.swm.designsystem.SearchHeader
import com.han.swm.domain.model.Shipment
import com.han.swm.domain.model.shipmentMock

@Composable
fun ShipmentScreenRoute(
    viewModel: ShipmentScreenViewModel = viewModel(),
    onGoToShipmentDetail: (id: Int) -> Unit
) {
    val shipments by viewModel.shipments.collectAsStateWithLifecycle()
    ShipmentScreen(
        shipments = shipments,
        onGoToShipmentDetail = onGoToShipmentDetail
    )
}

@Composable
private fun ShipmentScreen(
    shipments: List<Shipment>,
    onGoToShipmentDetail: (id: Int) -> Unit,
) {
    val context = LocalContext.current
    var searchText by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(15.dp)
            .padding(top = 20.dp)
    ) {
        SearchHeader(
            searchText = searchText,
            onSearchTextChange = {
                searchText = it
            }
        )

        Box(
            modifier = Modifier
                .padding(vertical = 25.dp)
                .clip(RoundedCornerShape(12.dp))
                .height(167.dp)
                .fillMaxWidth()
                .background(Color(0xFF4F75FF))
        ) {
            Image(
                modifier = Modifier.align(Alignment.BottomEnd).size(166.dp, 98.dp),
                painter = painterResource(R.drawable.img_shipment_bg),
                contentDescription = ""
            )
            Column (
                modifier = Modifier.padding(15.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Tra cứu tình trạng vận chuyển",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )

                    Text(
                        modifier = Modifier.padding(top = 5.dp).width(222.dp),
                        text = "Tra cứu ngay tình trạng vận chuyển của đơn hàng xuất kho của bạn",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light,
                            color = Color.White
                        )
                    )
                }

                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ghn.vn/"))
                        startActivity(context, intent, null)
                    },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Tra cứu")
                }
            }
        }

        Text(
            text = "Vận chuyển",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn {
            items(
                items = shipments,
                key = { it.id }
            ) {
                ShipmentCard(
                    date = it.date,
                    name = "${it.id} - ${it.type.name}",
                    status = it.status,
                    onClick = {
                        onGoToShipmentDetail(it.id)
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))

            }
        }


    }
}

@Preview
@Composable
private fun ShipmentScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ShipmentScreen(
            shipments = listOf(shipmentMock, shipmentMock.copy(id = 1)),
            onGoToShipmentDetail = {}
        )
    }
}


