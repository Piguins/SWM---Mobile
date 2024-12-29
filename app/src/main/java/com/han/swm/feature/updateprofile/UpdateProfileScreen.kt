package com.han.swm.feature.updateprofile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.han.swm.R
import com.han.swm.common.DateHelper
import com.han.swm.designsystem.TextBox
import com.han.swm.domain.model.User
import com.han.swm.domain.model.userMock

@Composable
fun UpdateProfileScreenRoute(
    viewModel: UpdateProfileScreenViewModel = viewModel(),
    onBack: () -> Unit
) {
    val user by viewModel.user.collectAsStateWithLifecycle()
    UpdateProfileScreen(
        user = user,
        onBack = onBack,
        onUpdateUserInfo = viewModel::onUpdateUserInfo
    )
}

@Composable
private fun UpdateProfileScreen(
    user: User,
    onBack: () -> Unit,
    onUpdateUserInfo: (user: User) -> Unit
) {
    val context = LocalContext.current
    var name by remember(user) { mutableStateOf(user.name) }
    var dob by remember(user) { mutableStateOf(user.dob) }
    var email by remember(user) { mutableStateOf(user.username) }
    var phone by remember(user) { mutableStateOf(user.phone) }

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

        Image(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(260.dp)
                .clip(shape = RoundedCornerShape(20.dp)),
            painter = painterResource(R.drawable.img_update_profile_bg),
            contentDescription = "",
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                TextBox(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Họ và tên",
                    placeholder = "Nguyễn Văn A",
                    value = name,
                    onValueChanged = { name = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextBox(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Ngày tháng năm sinh",
                    placeholder = "DD/MM/YYYY",
                    value = DateHelper.longToFormattedDateString(dob),
                    onValueChanged = { dob = DateHelper.stringToTimestamp(it) },
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextBox(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Email",
                    placeholder = "example@gmail.com",
                    value = email,
                    onValueChanged = { email = it },
                    keyboardType = KeyboardType.Email
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextBox(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Số điện thoại",
                    placeholder = "0919929119",
                    value = phone,
                    onValueChanged = { phone = it },
                    keyboardType = KeyboardType.Number
                )
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onUpdateUserInfo(
                    user.copy(
                        name = name,
                        dob = dob,
                        username = email,
                        phone = phone
                    )
                )
                Toast.makeText(
                    context,
                    "Thông tin đã được ghi nhận",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Text("Xác nhận")
        }
    }
}

@Preview
@Composable
private fun UpdateProfileScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        UpdateProfileScreen(
            user = userMock,
            onUpdateUserInfo = {},
            onBack = {}
        )
    }
}


