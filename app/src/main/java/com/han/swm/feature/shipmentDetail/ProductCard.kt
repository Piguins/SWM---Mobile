package com.han.swm.feature.shipmentDetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.han.swm.R
import com.han.swm.domain.model.Product
import com.han.swm.domain.model.productMock
import com.han.swm.feature.shipment.DateCard
import com.han.swm.feature.shipment.toColor

@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .clickable { onClick() }
    ) {
        AsyncImage(
            modifier = Modifier.size(58.dp),
            model = product.image,
            contentDescription = "",
            placeholder = painterResource(R.drawable.img_product_placeholder),
            error = painterResource(R.drawable.img_product_placeholder),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(25.dp))

        Column {
            Text(
                text = product.name,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = product.category.name,
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
private fun ProductCardPreview() {
    Surface {
        ProductCard(
            product = productMock,
            onClick = {}
        )
    }
}

