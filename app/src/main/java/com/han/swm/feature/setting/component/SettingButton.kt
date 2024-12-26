package com.han.swm.feature.setting.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.han.swm.R
import com.han.swm.ui.theme.SWMTheme

@Composable
fun SettingButton(
    @DrawableRes icon: Int,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconBackground: Color = MaterialTheme.colorScheme.primary
) {
    Row(
        modifier = modifier
            .padding(vertical = 25.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(30.dp)
                .background(iconBackground),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(icon),
                contentDescription = "icon",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(33.dp))

        Text(
            text = label,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
        )
    }
}

@Preview
@Composable
private fun SettingButtonPreview() {
    SWMTheme {
        Surface {
            SettingButton(
                icon = R.drawable.ic_book,
                label = "Hướng dẫn sử dụng",
                onClick = {}
            )
        }
    }
}

