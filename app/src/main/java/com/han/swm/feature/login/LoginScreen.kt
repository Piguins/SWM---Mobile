package com.han.swm.feature.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.han.swm.R
import com.han.swm.designsystem.TextBox
import com.han.swm.ui.theme.DarkBlue
import com.han.swm.ui.theme.SWMTheme

@Composable
fun LoginScreenRoute(
    viewModel: LoginScreenViewModel = viewModel(),
    onGoToForgotPassword: (String) -> Unit
) {
    LoginScreen(
        onForgotPassword = onGoToForgotPassword,
        onLogin = viewModel::onLogin
    )
}

@Composable
private fun LoginScreen(
    onForgotPassword: (String) -> Unit,
    onLogin: (String, String) -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth().height(180.dp)
                .clip(shape = RoundedCornerShape(20.dp)),
            painter = painterResource(R.drawable.img_login_bg),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier.padding(vertical = 25.dp),
            text = stringResource(R.string.welcome_text),
            style = MaterialTheme.typography.titleLarge
        )

        TextBox(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(R.string.email_title),
            placeholder = "Example@gmail.com",
            value = email,
            onValueChanged = { email = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextBox(
            modifier = Modifier.fillMaxWidth(),
            title = "Mật khẩu",
            placeholder = "Tối thiểu 8 ký tự",
            value = password,
            onValueChanged = { password = it }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                modifier = Modifier.clickable {
                    onForgotPassword(email)
                },
                text = "Quên mật khẩu?",
                color = DarkBlue
            )
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onLogin(email, password) }
        ) {
            Text("Đăng nhập")
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview(){
    SWMTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LoginScreen(
                onForgotPassword = {},
                onLogin = {_, _ -> }
            )
        }
    }
}


