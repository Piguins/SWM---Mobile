package com.han.swm.feature.notification

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.han.swm.common.DateHelper
import com.han.swm.domain.model.Notification
import com.han.swm.domain.model.notificationMock
import com.han.swm.feature.dashboard.NormalToggleButton
import com.han.swm.feature.log.LogScreenViewModel

@Composable
fun NotificationScreenRoute(
    viewModel: LogScreenViewModel = viewModel(),
    onBack: () -> Unit
) {
    NotificationScreen(
        onBack = onBack,
        notifications = listOf(notificationMock)
    )
}

enum class NotificationFilter {
    All, Unread
}

@Composable
private fun NotificationScreen(
    onBack: () -> Unit,
    notifications: List<Notification>
) {
    var filterBy by remember { mutableStateOf(NotificationFilter.All) }

    var filteredNotifications by remember(filterBy) {
        when (filterBy) {
            NotificationFilter.All -> mutableStateOf( notifications)
            NotificationFilter.Unread -> mutableStateOf( notifications.filter { !it.isRead })
        }
    }

    Column (
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
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
                text = "Thông báo",
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
            )

            Box(modifier = Modifier.width(28.dp))
        }

        Row(
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            NormalToggleButton(
                enabled = filterBy == NotificationFilter.All,
                onClick = {
                    filterBy = NotificationFilter.All
                }
            ) {
                Text("Tất cả")
            }

            Spacer(modifier = Modifier.width(10.dp))

            NormalToggleButton(
                enabled = filterBy == NotificationFilter.Unread,
                onClick = {
                    filterBy = NotificationFilter.Unread
                }
            ) {
                Text("Chưa đọc")
            }
        }

        LazyColumn() {
            items(
                items = filteredNotifications,
                key = { item -> item.id }
            ) {
                NotificationCard(
                    notification = it,
                    onClick = {}
                )
            }
        }
    }
}

@Composable
fun NotificationCard(
    notification: Notification,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .background(
                if (notification.isRead) Color(0xFFF4F5F7)
                else Color(0xFFE1F2FF)
            )
            .clickable(
                onClick = onClick
            )
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 18.dp,
                vertical = 15.dp
            )
        ) {
            Text(
                text = notification.title,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                notification.body
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = DateHelper.longToFormattedDateString(
                        value = notification.createdDate,
                        format = "hh:mm dd/MM/yyyy"
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun NotificationCardPreview() {
    Surface {
        NotificationCard(
            notificationMock,
            onClick = {}
        )
    }
}


@Preview
@Composable
private fun NotificationScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NotificationScreen(
            onBack = {},
            notifications = listOf(notificationMock)
        )
    }
}


