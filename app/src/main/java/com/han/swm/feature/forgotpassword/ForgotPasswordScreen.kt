package com.han.swm.feature.forgotpassword

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.han.swm.R
import com.han.swm.designsystem.TextBox
import com.han.swm.ui.theme.SWMTheme

@Composable
fun ForgotPasswordScreenRoute(
    viewModel: ForgotPasswordViewModel = viewModel(),
    onNavigateBack: () -> Unit,
) {
    ForgotPasswordScreen(
        onForgotPassword = viewModel::onForgotPassword,
        onBack = onNavigateBack,
        initEmail = viewModel.initEmail
    )
}

@Composable
private fun ForgotPasswordScreen(
    initEmail: String,
    onForgotPassword: (String) -> Unit,
    onBack: () -> Unit,
) {
    var email by remember { mutableStateOf(initEmail) }

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
            title = stringResource(R.string.email_title),
            placeholder = "Example@gmail.com",
            value = email,
            onValueChanged = { email = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onForgotPassword(email) }
        ) {
            Text("Xác nhận")
        }
    }
}

@Preview
@Composable
private fun ForgotPasswordScreenPreview(){
    SWMTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            ForgotPasswordScreen(
                onForgotPassword = {},
                onBack = {},
                initEmail = ""
            )
        }
    }
}


