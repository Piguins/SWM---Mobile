package com.han.swm.feature.stock

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.han.swm.designsystem.SearchHeader
import com.han.swm.domain.model.Stock
import com.han.swm.domain.model.stockMock

@Composable
fun StockScreenRoute(
    viewModel: StockScreenViewModel = viewModel(),
    onGoToProductDetail: (id: Int) -> Unit
) {
    val stocks by viewModel.stocks.collectAsStateWithLifecycle()

    StockScreen(
        stocks = stocks,
        onGoToProductDetail = onGoToProductDetail
    )
}

@Composable
private fun StockScreen(
    stocks: List<Stock>,
    onGoToProductDetail: (id: Int) -> Unit,
) {
    val latestStock = remember(stocks) {
        if (stocks.isNotEmpty()) {
            stocks.maxBy { it.createdDate }
        } else stockMock
    }

    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        SearchHeader(
            searchText = searchText,
            onSearchTextChange = { searchText = it }
        )

        Text(
            modifier = Modifier.padding(vertical = 15.dp),
            text = "Thêm vào gần đây",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(color = Color(0xFF4F75FF))
                .clickable {
                    onGoToProductDetail(latestStock.id)
                }
        ) {
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(15.dp),
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
           ) {
               Column(
                   modifier = Modifier.weight(1f)
               ) {
                   Text(
                       text = latestStock.product.name,
                       style = TextStyle(
                           fontSize = 15.sp,
                           fontWeight = FontWeight.Bold,
                           color = Color.White
                       )
                   )
                   Spacer(modifier = Modifier.height(5.dp))
                   Text(
                       text = latestStock.product.sku,
                       style = TextStyle(
                           fontSize = 12.sp,
                           color = Color.White
                       )
                   )
               }
               Text(
                   modifier = Modifier.weight(1f),
                   text = latestStock.product.tags.first().name,
                   style = TextStyle(
                       fontSize = 15.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White
                   )
               )
               Box(

                   modifier = Modifier
                       .width(52.dp)
                       .clip(RoundedCornerShape(7.dp))
                       .background(color = Color.White),
                   contentAlignment = Alignment.Center
               ) {
                   Text(
                       modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                       text = latestStock.quantity.toString()
                   )
               }
           }
        }

        Text(
            modifier = Modifier.padding(vertical = 15.dp),
            text = "Danh sách sản phẩm",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )
        )

        LazyColumn { 
            items(
                items = stocks,
                key = { it.id }
            ) { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            onGoToProductDetail(item.id)
                        }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                        ) {
                            Text(
                                text = item.product.name,
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF4F75FF)
                                )
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = item.product.sku,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    color = Color(0xFFAEC0FF)
                                )
                            )
                        }
                        Text(
                            modifier = Modifier.weight(1f),
                            text = item.product.tags.first().name,
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF4F75FF)
                            )
                        )
                        Box(
                            modifier = Modifier
                                .width(52.dp)
                                .clip(RoundedCornerShape(7.dp))
                                .background(color = Color(0xFF4F75FF)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                                text = item.quantity.toString(),
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ProductScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        StockScreen(
            stocks = listOf(stockMock),
            onGoToProductDetail = { }
        )
    }
}


