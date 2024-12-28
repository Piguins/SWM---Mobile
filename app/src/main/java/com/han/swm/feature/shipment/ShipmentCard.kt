package com.han.swm.feature.shipment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.han.swm.common.DateHelper
import com.han.swm.domain.model.ShipmentStatus

fun ShipmentStatus.toColor(): Color {
    return when (this) {
        ShipmentStatus.InProgress -> Color(0xFF4F75FF)
        ShipmentStatus.Success -> Color(0xFF289A00)
        ShipmentStatus.Failure -> Color(0xFFFF0307)
    }
}

@Composable
fun DateCard(
    date: Long,
    background: Color,
    textColor: Color = Color.White
) {
    Box(
        modifier = Modifier
            .size(62.dp, 58.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 9.dp,
                    topEnd = 25.dp,
                    bottomEnd = 9.dp,
                    bottomStart = 9.dp,
                )
            )
            .background(background)
    ) {
        Column(
            modifier = Modifier.padding(10.dp).fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = DateHelper.longToFormattedDateString(
                    value = date,
                    format = "d MMM"
                ),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = textColor
                )
            )
            Text(
                text = DateHelper.longToFormattedDateString(
                    value = date,
                    format = "EEE"
                ),
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = textColor
                )
            )
        }
    }
}

@Composable
fun ShipmentCard(
    date: Long,
    name: String,
    status: ShipmentStatus,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .clickable { onClick() }
    ) {
        DateCard(
            date = date,
            background = status.toColor()
        )

        Spacer(modifier = Modifier.width(25.dp))

        Column {
            Text(
                text = name,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = status.label,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                )
            )
        }
    }
}

@Preview
@Composable
private fun ShipmentCardPreview() {
    Surface {
        ShipmentCard(
            date = System.currentTimeMillis(),
            name = "Apple Iphone 12 Plus",
            status = ShipmentStatus.Success,
            onClick = {}
        )
    }
}

