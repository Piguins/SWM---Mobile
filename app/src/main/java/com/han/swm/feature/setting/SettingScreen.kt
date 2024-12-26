package com.han.swm.feature.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.han.swm.R
import com.han.swm.feature.setting.component.SettingButton
import com.han.swm.ui.theme.SWMTheme

@Composable
fun SettingScreenRoute(
    onGoToChangePassword: () -> Unit,
    onGoToUpdateInfo: () -> Unit,
    onGoToUserInfo: () -> Unit,
    onGoToActivity: () -> Unit,
    onGoToGuide: () -> Unit,
    onGoToLogin: () -> Unit,
    viewModel: SettingScreenViewModel = viewModel()
) {
    SettingScreen(
        onGoToChangePassword = onGoToChangePassword,
        onGoToUpdateInfo = onGoToUpdateInfo,
        onGoToActivity = onGoToActivity,
        onGoToGuide = onGoToGuide,
        onGoToUserInfo = onGoToUserInfo,
        onLogout = {
            viewModel.onLogout()
            onGoToLogin()
        }
    )
}

@Composable
private fun SettingScreen(
    onGoToChangePassword: () -> Unit,
    onGoToUpdateInfo: () -> Unit,
    onGoToUserInfo: () -> Unit,
    onGoToActivity: () -> Unit,
    onGoToGuide: () -> Unit,
    onLogout: () -> Unit,
) {
    Box {
        Image(
            modifier = Modifier
                .height(
//                    428.dp,
                    234.dp
                )
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        bottomStart = 12.dp,
                        bottomEnd = 12.dp
                    )
                ),
            painter = painterResource(R.drawable.img_profile_bg),
            contentDescription = "background image",
            contentScale = ContentScale.Crop
        )
        Box (
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .padding(
                    top = 176.dp,
                    bottom = 25.dp
                )
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 35.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    item {

                        SettingButton(
                            icon = R.drawable.ic_key,
                            onClick = onGoToChangePassword,
                            label = "Đổi mật khẩu"
                        )

                        HorizontalDivider()
                    }

                    item {
                        SettingButton(
                            icon = R.drawable.ic_person,
                            onClick = onGoToUpdateInfo,
                            label = "Cập nhật thông tin cá nhân"
                        )

                        HorizontalDivider()

                    }
                    item {
                        SettingButton(
                            icon = R.drawable.ic_person,
                            onClick = onGoToUserInfo,
                            label = "Thông tin cá nhân"
                        )

                        HorizontalDivider()

                    }
                    item {
                        SettingButton(
                            icon = R.drawable.ic_diary,
                            onClick = onGoToActivity,
                            label = "Nhật ký hoạt động"
                        )

                        HorizontalDivider()

                    }
                    item {
                        SettingButton(
                            icon = R.drawable.ic_book,
                            onClick = onGoToGuide,
                            label = "Hướng dẫn sử dụng"
                        )

                    }
                }
                HorizontalDivider()

                SettingButton(
//                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_exit,
                    onClick = onLogout,
                    label = "Đăng xuất",
                    iconBackground = Color(0xFFFF0307)
                )
            }
        }
    }
}

@Preview
@Composable
private fun SettingScreenPreview(){
    SWMTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            SettingScreen(
                onGoToChangePassword = {},
                onGoToUpdateInfo = {},
                onGoToUserInfo = {},
                onGoToActivity = {  },
                onGoToGuide = {},
                onLogout = {  }
            )
        }
    }
}


