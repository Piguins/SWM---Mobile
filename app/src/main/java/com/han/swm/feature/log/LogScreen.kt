package com.han.swm.feature.log

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.han.swm.common.DateHelper
import com.han.swm.domain.model.ActivityLog
import com.han.swm.domain.model.logMock

@Composable
fun LogScreenRoute(
    viewModel: LogScreenViewModel = viewModel(),
    onBack: () -> Unit
) {
    LogScreen(
        onBack = onBack,
        logs = listOf(logMock)
    )
}

@Composable
private fun LogScreen(
    onBack: () -> Unit,
    logs: List<ActivityLog>
) {
    Column (
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

        LazyColumn(
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            items(
                items = logs,
                key = { item -> item.id }
            ) {
                LogCard(it)
            }
        }
    }
}

@Composable
fun LogCard(
    log: ActivityLog
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .background(Color(0xFFE1F2FF))
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 18.dp,
                vertical = 15.dp
            )
        ) {
            Text(
                text = DateHelper.longToFormattedDateString(
                    value = log.timestamp,
                    format = "hh:mm dd/MM/yyyy"
                ),
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                log.description
            )
        }
    }
}

@Preview
@Composable
private fun LogCardPreview() {
    Surface {
        LogCard(
            log = logMock
        )
    }
}


@Preview
@Composable
private fun LogScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LogScreen(
            onBack = {},
            logs = listOf(logMock)
        )
    }
}


