package com.han.swm.feature.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.han.swm.R
import com.han.swm.common.DateHelper
import com.han.swm.designsystem.TextBox
import com.han.swm.domain.model.User
import com.han.swm.domain.model.userMock
import com.han.swm.ui.theme.DarkBlue

@Composable
fun ProfileDetailScreenRoute(
    viewModel: ProfileDetailScreenViewModel = viewModel(),
    onBack: () -> Unit,
) {
    val user by viewModel.user.collectAsStateWithLifecycle()
    ProfileDetailScreen(
        user = user,
        onBack = onBack,
        onReport = viewModel::onReport
    )
}

@Composable
private fun ProfileDetailScreen(
    user: User,
    onBack: () -> Unit,
    onReport: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(20.dp).verticalScroll(rememberScrollState())
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
        Row(
            modifier = Modifier.padding(
                vertical = 25.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = user.imageUrl,
                contentDescription = "",
                modifier = Modifier.clip(CircleShape).size(50.dp),
                placeholder = painterResource(R.drawable.img_avatar_default),
                error = painterResource(R.drawable.img_avatar_default),
            )

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = "Hi, ${user.name}",
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        TextBox(
            modifier = Modifier.fillMaxWidth(),
            title = "Họ và tên",
            placeholder = "N/A",
            value = user.name,
            onValueChanged = { },
            enabled = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextBox(
            modifier = Modifier.fillMaxWidth(),
            title = "Phòng ban",
            placeholder = "N/A",
            value = user.department,
            onValueChanged = {  },
            enabled = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextBox(
            modifier = Modifier.fillMaxWidth(),
            title = "Chức vụ",
            placeholder = "N/A",
            value = user.position,
            onValueChanged = { },
            enabled = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextBox(
            modifier = Modifier.fillMaxWidth(),
            title = "Email",
            placeholder = "N/A",
            value = user.username,
            onValueChanged = { },
            enabled = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextBox(
            modifier = Modifier.fillMaxWidth(),
            title = "Số điện thoại",
            placeholder = "N/A",
            value = user.phone,
            onValueChanged = { },
            enabled = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                modifier = Modifier.clickable {
                    onReport()
                },
                text = "Có sai sót? Bấm để báo cáo",
                color = DarkBlue
            )
        }
    }
}

@Preview
@Composable
private fun ProfileDetailScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ProfileDetailScreen(
            user = userMock,
            onBack = {},
            onReport = {}
        )
    }
}


