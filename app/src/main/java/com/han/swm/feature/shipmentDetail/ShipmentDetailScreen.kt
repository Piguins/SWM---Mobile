package com.han.swm.feature.shipmentDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.han.swm.R
import com.han.swm.domain.model.Shipment
import com.han.swm.domain.model.productMock
import com.han.swm.domain.model.shipmentMock
import com.han.swm.feature.shipment.DateCard
import com.han.swm.feature.shipment.ShipmentScreenViewModel
import com.han.swm.feature.shipment.toColor

@Composable
fun ShipmentDetailScreenRoute(
    viewModel: ShipmentDetailScreenViewModel = viewModel(),
    onBack: () -> Unit
) {
    val shipment by viewModel.shipment.collectAsStateWithLifecycle()
    ShipmentDetailScreen(
        onBack = onBack,
        shipment = shipment
    )
}

@Composable
private fun ShipmentDetailScreen(
    onBack: () -> Unit,
    shipment: Shipment
) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        IconButton(
            modifier = Modifier.size(28.dp),
            onClick = onBack,
            colors = IconButtonDefaults.iconButtonColors().copy(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Icon(
                modifier = Modifier.size(15.dp),
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = ""
            )
        }

        Text(
            modifier = Modifier.padding(vertical = 15.dp),
            text = "Thông tin giao hàng",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )
        )
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 15.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DateCard(
                date = shipment.date,
                background = shipment.status.toColor()
            )

            Text (
                text = shipment.type.name
            )

            Text (
                text = shipment.status.label
            )
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth()
//                .height(121.dp)
                .background(color = Color(0xFFE1F2FF))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Image(
                    modifier = Modifier
                        .height(130.dp)
                        .width(20.dp),
                    painter = painterResource(R.drawable.img_shipment_detail_card),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(15.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .height(130.dp)
                        .padding(end = 15.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Từ",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                        )
                    )
                    Text(
                        text = shipment.senderAddress,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                        )
                    )
                    HorizontalDivider()
                    Text(
                        text = "Đến",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                        )
                    )
                    Text(
                        text = shipment.receiverAddress,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                        )
                    )
                }
            }
        }

        Text(
            modifier = Modifier.padding(vertical = 15.dp),
            text = "Sản phẩm",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )
        )

        LazyColumn {
            items(
                items = shipment.products,
                key = { it.id }
            ) { product ->
                ProductCard(
                    modifier = Modifier.padding(bottom = 15.dp),
                    product = product,
                    onClick = {}
                )
            }
        }
    }
}

@Preview
@Composable
private fun ShipmentDetailScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ShipmentDetailScreen(
            onBack = {},
            shipment = shipmentMock
        )
    }
}



