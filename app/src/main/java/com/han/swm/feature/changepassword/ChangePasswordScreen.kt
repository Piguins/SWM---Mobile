package com.han.swm.feature.changepassword

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.han.swm.R
import com.han.swm.designsystem.TextBox
import com.han.swm.feature.auth.forgotpassword.ForgotPasswordViewModel
import com.han.swm.ui.theme.SWMTheme

@Composable
fun ChangePasswordScreenRoute(
    viewModel: ChangePasswordViewModel = viewModel(),
    onNavigateBack: () -> Unit,
) {
    ChangePasswordScreen(
        onChangePassword = viewModel::onChangePassword,
        onBack = onNavigateBack,
    )
}

@Composable
private fun ChangePasswordScreen(
    onChangePassword: (String, String, String) -> Unit,
    onBack: () -> Unit,
) {
    val context = LocalContext.current

    var currentPw by remember { mutableStateOf("") }
    var newPw by remember { mutableStateOf("") }
    var confirmPw by remember { mutableStateOf("") }

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
            modifier = Modifier.fillMaxWidth().height(290.dp)
                .clip(shape = RoundedCornerShape(20.dp)),
            painter = painterResource(R.drawable.img_forgot_password_bg),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        TextBox(
            modifier = Modifier.fillMaxWidth(),
            title = "Mật khẩu hiện tại",
            placeholder = "********",
            value = currentPw,
            onValueChanged = { currentPw = it },
            keyboardType = KeyboardType.Password
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextBox(
            modifier = Modifier.fillMaxWidth(),
            title = "Mật khẩu mới",
            placeholder = "********",
            value = newPw,
            onValueChanged = { newPw = it },
            keyboardType = KeyboardType.Password
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextBox(
            modifier = Modifier.fillMaxWidth(),
            title = "Xác nhận mật khẩu",
            placeholder = "********",
            value = confirmPw,
            onValueChanged = { confirmPw = it },
            keyboardType = KeyboardType.Password
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onChangePassword(currentPw, newPw, confirmPw)
                Toast.makeText(
                    context,
                    "Đổi mật khẩu thành công",
                    Toast.LENGTH_SHORT
                ).show()
                onBack()
            }
        ) {
            Text("Xác nhận")
        }
    }
}

@Preview
@Composable
private fun ChangePasswordScreenPreview(){
    SWMTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            ChangePasswordScreen(
                onChangePassword = {_, _, _ ->},
                onBack = {},
            )
        }
    }
}


