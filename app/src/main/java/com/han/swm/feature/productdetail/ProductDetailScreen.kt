package com.han.swm.feature.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.han.swm.R
import com.han.swm.domain.model.Product
import com.han.swm.domain.model.productMock
import com.han.swm.feature.stock.StockScreenViewModel
import com.han.swm.ui.theme.SWMTheme

@Composable
fun ProductDetailScreenRoute(
    viewModel: ProductDetailScreenViewModel = viewModel(),
    onBack: () -> Unit
) {
    val product by viewModel.product.collectAsStateWithLifecycle()

    ProductDetailScreen(
        onBack = onBack,
        product = product
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ProductDetailScreen(
    product: Product,
    onBack: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        IconButton (
            modifier = Modifier.size(28.dp),
            onClick = onBack,
            colors = IconButtonDefaults.iconButtonColors().copy(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Icon(
                modifier = Modifier.size(15.dp),
                imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = ""
            )
        }

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp)
                .padding(15.dp)
                .clip(shape = RoundedCornerShape(20.dp)),
            model = product.image,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.img_product_placeholder),
            error = painterResource(R.drawable.img_product_placeholder)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = product.name,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = product.sku,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFF1F9FF))
                .fillMaxWidth()
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF0B4AF5))
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                horizontal = 20.dp,
                                vertical = 12.dp
                            ),
                        text = "Thông tin chung",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    )
                }
                Column (
                    modifier = Modifier
                        .padding(
                            horizontal = 20.dp,
                            vertical = 12.dp
                        ),
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    ) {

                        Column (
                            modifier = Modifier.width(150.dp),
                        ) {
                            Text(text = "Hãng sản xuất",)
                            Text("Danh mục")
                            Text("Giá thị trường")

                        }

                        Column (
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = product.company.name,)
                            Text(text = product.category.name)
                            Text(text = product.marketPrice.toString())
                        }
                    }
                    Text("Tags")
                    FlowRow(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        product.tags.forEach {
                            Box (
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .padding(end = 5.dp)
                                    .background(Color.White)
                                    .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp),
                                    text = it.name
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    SWMTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            ProductDetailScreen(
                onBack = {},
                product = productMock
            )
        }
    }
}


