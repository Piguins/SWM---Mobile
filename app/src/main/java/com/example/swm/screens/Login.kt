package com.example.swm.screens
import androidx.compose.runtime.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.layout.*
import com.example.swm.constants.MyColors
import com.example.swm.constants.MyFontSize
import com.example.swm.constants.MyImages
import com.skydoves.landscapist.*
import com.skydoves.landscapist.coil.CoilImage


@Composable
fun Login() {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight()
			.background(
				color = MyColors.surfaceContainerLowest,
			)
	){
		Column(
			modifier = Modifier
				.clip(shape = RoundedCornerShape(12.dp))
				.fillMaxWidth()
				.weight(1f)
				.background(
					color = MyColors.surfaceContainerLowest,
					shape = RoundedCornerShape(12.dp)
				)
				.padding(top = 24.dp,end = 24.dp,)
				.verticalScroll(rememberScrollState())
		){
			CoilImage(
				imageModel = {"https://i.imgur.com/1tMFzp8.png"},
				imageOptions = ImageOptions(contentScale = ContentScale.Crop),
				modifier = Modifier
					.padding(bottom = 25.dp,start = 24.dp,)
					.clip(shape = RoundedCornerShape(20.dp))
					.height(180.dp)
					.fillMaxWidth()
			)
			Text("Welcome Back,",
				color = MyColors.shadow,
				fontSize = MyFontSize.headline_small,
				modifier = Modifier
					.padding(bottom = 28.dp,start = 25.dp,)
			)
			Text("Email",
				color = Color(0xFF0B1420),
				fontSize = MyFontSize.body_medium,
				modifier = Modifier
					.padding(bottom = 6.dp,start = 26.dp,)
			)
			Column(
				modifier = Modifier
					.padding(bottom = 18.dp,start = 24.dp,)
					.border(
						width = 1.dp,
						color = Color(0xFFD4D7E3),
						shape = RoundedCornerShape(8.dp)
					)
					.clip(shape = RoundedCornerShape(8.dp))
					.fillMaxWidth()
					.background(
						color = Color(0xFFF2F6FA),
						shape = RoundedCornerShape(8.dp)
					)
					.padding(16.dp)
			){
				Text("Example@email.com",
					color = Color(0xFF8796AD),
					fontSize = MyFontSize.body_medium,
				)
			}
			Text("Password",
				color = Color(0xFF0B1420),
				fontSize = MyFontSize.body_medium,
				modifier = Modifier
					.padding(bottom = 6.dp,start = 26.dp,)
			)
			Column(
				modifier = Modifier
					.padding(bottom = 11.dp,start = 24.dp,)
					.border(
						width = 1.dp,
						color = Color(0xFFD4D7E3),
						shape = RoundedCornerShape(8.dp)
					)
					.clip(shape = RoundedCornerShape(8.dp))
					.fillMaxWidth()
					.background(
						color = Color(0xFFF2F6FA),
						shape = RoundedCornerShape(8.dp)
					)
					.padding(vertical = 13.dp,horizontal = 15.dp,)
			){
				Text("Tối thiểu 8 ký tự",
					color = Color(0xFF8796AD),
					fontSize = MyFontSize.body_medium,
				)
			}
			Text("Quên mật khẩu?",
				color = Color(0xFF1D4AE8),
				fontSize = MyFontSize.body_medium,
				modifier = Modifier
					.padding(bottom = 21.dp,start = 267.dp,)
			)
			Column(
				horizontalAlignment = Alignment.CenterHorizontally,
				modifier = Modifier
					.padding(start = 24.dp,)
					.clip(shape = RoundedCornerShape(12.dp))
					.fillMaxWidth()
					.background(
						color = Color(0xFF636AE8),
						shape = RoundedCornerShape(12.dp)
					)
					.padding(vertical = 15.dp,)
			){
				Text("Đăng nhập",
					color = MyColors.surfaceContainerLowest,
					fontSize = MyFontSize.body_large,
				)
			}
		}
	}
}