package com.han.swm.feature.dashboard

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.han.swm.R
import com.han.swm.domain.model.Statistic
import com.han.swm.domain.model.User
import com.han.swm.domain.model.WeekStatistic
import com.han.swm.domain.model.statisticMock
import com.han.swm.domain.model.userMock
import com.han.swm.domain.model.weekStatisticMock
import com.han.swm.ui.theme.SWMTheme
import ir.ehsannarmani.compose_charts.ColumnChart
import ir.ehsannarmani.compose_charts.models.BarProperties
import ir.ehsannarmani.compose_charts.models.Bars

enum class DashBoardType {
    Inventory,
    Imported,
    Import
}

data class DashBoardScreenUiState(
    val user: User,
    val dashBoardType: DashBoardType = DashBoardType.Inventory,
    val weekStatistic: WeekStatistic,
    val statistic: Statistic
)

@Composable
fun DashBoardScreenRoute(
    viewModel: DashBoardScreenViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    DashBoardScreen(
        uiState = uiState,
        onChangeDashboardType = viewModel::onChangeDashBoardType
    )
}

@Composable
fun NormalToggleButton(
    enabled: Boolean,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    if (enabled) {
        Button(onClick = onClick) { content() }
    } else {
        OutlinedButton(onClick = onClick) { content() }
    }
}

@Composable
private fun DashBoardScreen(
    uiState: DashBoardScreenUiState,
    onChangeDashboardType: (DashBoardType) -> Unit,
) {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Row(
            modifier = Modifier
                .padding(
                    top = 30.dp,
                    bottom = 17.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.width(222.dp)
            ) {
                Text("Have a good day ${uiState.user.name}")
                Text("Công việc của bạn thật tuyệt, tiếp tục phát huy nhé")
            }

            IconButton(
                colors = IconButtonDefaults.iconButtonColors().copy(
                    containerColor = Color.LightGray,
                    contentColor = Color.DarkGray
                ),
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = ""
                )
            }
        }

        LazyRow(
        ) {
            item {
                NormalToggleButton(
                    enabled = uiState.dashBoardType == DashBoardType.Inventory,
                    onClick = { onChangeDashboardType(DashBoardType.Inventory) }
                ) {
                    Text("Hàng trong kho")
                }
                Spacer(modifier = Modifier.width(15.dp))
            }
            item {
                NormalToggleButton(
                    enabled = uiState.dashBoardType == DashBoardType.Imported,
                    onClick = { onChangeDashboardType(DashBoardType.Imported) }
                ) {
                    Text("Hàng đã nhập")
                }
                Spacer(modifier = Modifier.width(15.dp))
            }
            item {
                NormalToggleButton(
                    enabled = uiState.dashBoardType == DashBoardType.Import,
                    onClick = { onChangeDashboardType(DashBoardType.Import) }
                ) {
                    Text("Hàng cần nhập")
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 15.dp)
                ) {
                    Text(
                        text = when (uiState.dashBoardType) {
                            DashBoardType.Inventory -> "Hàng trong kho"
                            DashBoardType.Imported -> "Hàng đã nhập"
                            DashBoardType.Import -> "Hàng cần nhập"
                        },
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = when (uiState.dashBoardType) {
                            DashBoardType.Inventory -> uiState.statistic.stockNumber.toInt()
                                .toString()

                            DashBoardType.Imported -> uiState.statistic.indboundNumber.toInt()
                                .toString()

                            DashBoardType.Import -> uiState.statistic.inboundNeededNumber.toInt()
                                .toString()
                        },
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = when (uiState.dashBoardType) {
                                DashBoardType.Inventory,
                                DashBoardType.Imported -> MaterialTheme.colorScheme.primary

                                DashBoardType.Import -> Color(0xFFEC3636)
                            },
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_income_rising),
                            contentDescription = "",
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = when (uiState.dashBoardType) {
                                DashBoardType.Inventory -> uiState.statistic.stockPercentChange
                                DashBoardType.Imported -> uiState.statistic.inboundPercentChange
                                DashBoardType.Import -> uiState.statistic.inboundNeededPercentChange
                            } + " so với tháng trước",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
                Icon(
                    painter = painterResource(R.drawable.ic_inventory),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            }
        }

        Text(
            text = "Trạng thái trong tuần",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )

        ColumnChart(
            modifier = Modifier.padding(22.dp),
            data = remember(uiState) {
                listOf(
                    Bars(
                        label = "Sat",
                        values = listOf(
                            Bars.Data(
                                label = "Import",
                                value = uiState.weekStatistic.stats.first { it.day == "Sat" }.nhap.toDouble(),
                                color = SolidColor(Color(0xFF1814F3))
                            ),
                            Bars.Data(
                                label = "Export",
                                value = uiState.weekStatistic.stats.first { it.day == "Sat" }.xuat.toDouble(),
                                color = SolidColor(Color(0xFF16DBCC))
                            )
                        ),
                    ),
                    Bars(
                        label = "Sun",
                        values = listOf(
                            Bars.Data(
                                label = "Import",
                                value = uiState.weekStatistic.stats.first { it.day == "Sun" }.nhap.toDouble(),
                                color = SolidColor(Color(0xFF1814F3))
                            ),
                            Bars.Data(
                                label = "Export",
                                value = uiState.weekStatistic.stats.first { it.day == "Sun" }.xuat.toDouble(),
                                color = SolidColor(Color(0xFF16DBCC))
                            )
                        ),
                    ),
                    Bars(
                        label = "Mon",
                        values = listOf(
                            Bars.Data(
                                label = "Import",
                                value = uiState.weekStatistic.stats.first { it.day == "Mon" }.nhap.toDouble(),
                                color = SolidColor(Color(0xFF1814F3))
                            ),
                            Bars.Data(
                                label = "Export",
                                value = uiState.weekStatistic.stats.first { it.day == "Mon" }.xuat.toDouble(),
                                color = SolidColor(Color(0xFF16DBCC))
                            )
                        ),
                    ),
                    Bars(
                        label = "Tue",
                        values = listOf(
                            Bars.Data(
                                label = "Import",
                                value = uiState.weekStatistic.stats.first { it.day == "Tue" }.nhap.toDouble(),
                                color = SolidColor(Color(0xFF1814F3))
                            ),
                            Bars.Data(
                                label = "Export",
                                value = uiState.weekStatistic.stats.first { it.day == "Tue" }.xuat.toDouble(),
                                color = SolidColor(Color(0xFF16DBCC))
                            )
                        ),
                    ),
                    Bars(
                        label = "Wed",
                        values = listOf(
                            Bars.Data(
                                label = "Import",
                                value = uiState.weekStatistic.stats.first { it.day == "Wed" }.nhap.toDouble(),
                                color = SolidColor(Color(0xFF1814F3))
                            ),
                            Bars.Data(
                                label = "Export",
                                value = uiState.weekStatistic.stats.first { it.day == "Wed" }.xuat.toDouble(),
                                color = SolidColor(Color(0xFF16DBCC))
                            )
                        ),
                    ),
                    Bars(
                        label = "Thu",
                        values = listOf(
                            Bars.Data(
                                label = "Import",
                                value = uiState.weekStatistic.stats.first { it.day == "Thu" }.nhap.toDouble(),
                                color = SolidColor(Color(0xFF1814F3))
                            ),
                            Bars.Data(
                                label = "Export",
                                value = uiState.weekStatistic.stats.first { it.day == "Thu" }.xuat.toDouble(),
                                color = SolidColor(Color(0xFF16DBCC))
                            )
                        ),
                    ),
                    Bars(
                        label = "Fri",
                        values = listOf(
                            Bars.Data(
                                label = "Import",
                                value = uiState.weekStatistic.stats.first { it.day == "Fri" }.nhap.toDouble(),
                                color = SolidColor(Color(0xFF1814F3))
                            ),
                            Bars.Data(
                                label = "Export",
                                value = uiState.weekStatistic.stats.first { it.day == "Fri" }.xuat.toDouble(),
                                color = SolidColor(Color(0xFF16DBCC))
                            )
                        ),
                    ),
                )
            },
            barProperties = BarProperties(
                cornerRadius = Bars.Data.Radius.Rectangle(
                    topRight = 6.dp,
                    topLeft = 6.dp
                ),
                spacing = 3.dp,
                thickness = 20.dp
            ),
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            ),
        )

    }

}

@Preview
@Composable
private fun DashBoardScreenPreview() {
    SWMTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            DashBoardScreen(
                uiState = DashBoardScreenUiState(
                    user = userMock,
                    weekStatistic = weekStatisticMock,
                    statistic = statisticMock
                ),
                onChangeDashboardType = {}
            )
        }
    }
}


