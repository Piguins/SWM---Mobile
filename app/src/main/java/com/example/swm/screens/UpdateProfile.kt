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
import androidx.compose.ui.text.*
import androidx.compose.ui.layout.*
import com.skydoves.landscapist.*
import com.skydoves.landscapist.coil3.*
@Composable
fun 5_2CậPNhậTThôNgTinTàIKhoảN() {
	val textField1 = remember { mutableStateOf("") }
	val textField2 = remember { mutableStateOf("") }
	val textField3 = remember { mutableStateOf("") }
	val textField4 = remember { mutableStateOf("") }
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight()
			.background(
				color = Color(0xFFFFFFFF),
			)
	){
		Column(
			modifier = Modifier
				.clip(shape = RoundedCornerShape(12.dp))
				.fillMaxWidth()
				.weight(1f)
				.background(
					color = Color(0xFFFFFFFF),
					shape = RoundedCornerShape(12.dp)
				)
				.padding(top = 38.dp,start = 43.dp,end = 43.dp,)
				.verticalScroll(rememberScrollState())
		){
			Row(
				modifier = Modifier
					.padding(bottom = 24.dp,)
					.fillMaxWidth()
			){
				Column(
					modifier = Modifier
						.padding(end = 1.dp,)
						.clip(shape = RoundedCornerShape(90.dp))
						.width(28.dp)
						.background(
							color = Color(0xFF4F75FF),
							shape = RoundedCornerShape(90.dp)
						)
						.padding(horizontal = 4.dp,)
				){
					CoilImage(
						imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/cce60123-ee44-4c95-945a-ccbacde340e2"},
						imageOptions = ImageOptions(contentScale = ContentScale.Crop),
						modifier = Modifier
							.padding(top = 5.dp,)
							.height(18.dp)
							.fillMaxWidth()
					)
				}
				Box(
					modifier = Modifier
						.padding(top = 45.dp,)
				){
					Column(
						modifier = Modifier
							.width(292.dp)
					){
						Box{
							Column(
								modifier = Modifier
									.fillMaxWidth()
							){
								CoilImage(
									imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/c1843d6c-fbd2-4075-bc28-7d3b21e43651"},
									imageOptions = ImageOptions(contentScale = ContentScale.Crop),
									modifier = Modifier
										.clip(shape = RoundedCornerShape(12.dp))
										.height(217.dp)
										.fillMaxWidth()
								)
							}
							CoilImage(
								imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/24db9207-3469-4fa0-b6ba-6356f00ed9cb"},
								imageOptions = ImageOptions(contentScale = ContentScale.Crop),
								modifier = Modifier
									.offset(x = 1.dp, y = 0.dp)
									.align(Alignment.BottomEnd)
									.padding(start = 1.dp)
									.clip(shape = RoundedCornerShape(12.dp))
									.width(45.dp)
									.height(34.dp)
							)
						}
					}
					CoilImage(
						imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/04cd2c2d-f06c-44a2-b0bf-8b4b8d85a04f"},
						imageOptions = ImageOptions(contentScale = ContentScale.Crop),
						modifier = Modifier
							.offset(x = 2.dp, y = -22.dp)
							.align(Alignment.TopEnd)
							.padding(start = 2.dp)
							.clip(shape = RoundedCornerShape(12.dp))
							.width(271.dp)
							.height(42.dp)
					)
				}
			}
			Text("Họ và tên",
				color = Color(0xFF0B1420),
				fontSize = 14.sp,
				modifier = Modifier
					.padding(bottom = 11.dp,)
			)
			TextFieldView(
				placeholder = "Tô Thế Kiệt",
				value = textField1.value,
				onValueChange = { newText -> textField1.value = newText },
				textStyle = TextStyle(
					color = Color(0xFF8796AD),
					fontSize = 14.sp,
				),
				modifier = Modifier
					.padding(bottom = 26.dp,)
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
					.padding(14.dp)
			)
			Text("Ngày tháng năm sinh",
				color = Color(0xFF0B1420),
				fontSize = 14.sp,
				modifier = Modifier
					.padding(bottom = 11.dp,)
			)
			TextFieldView(
				placeholder = "08/10/2003",
				value = textField2.value,
				onValueChange = { newText -> textField2.value = newText },
				textStyle = TextStyle(
					color = Color(0xFF8796AD),
					fontSize = 14.sp,
				),
				modifier = Modifier
					.padding(bottom = 23.dp,)
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
					.padding(vertical = 12.dp,horizontal = 14.dp,)
			)
			Text("Email liên hệ",
				color = Color(0xFF0B1420),
				fontSize = 14.sp,
				modifier = Modifier
					.padding(bottom = 11.dp,)
			)
			TextFieldView(
				placeholder = "21522263@gm.uit.edu.vn",
				value = textField3.value,
				onValueChange = { newText -> textField3.value = newText },
				textStyle = TextStyle(
					color = Color(0xFF8796AD),
					fontSize = 14.sp,
				),
				modifier = Modifier
					.padding(bottom = 21.dp,)
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
					.padding(vertical = 15.dp,horizontal = 14.dp,)
			)
			Text("Số điện thoại liên hệ",
				color = Color(0xFF0B1420),
				fontSize = 14.sp,
				modifier = Modifier
					.padding(bottom = 13.dp,)
			)
			TextFieldView(
				placeholder = "0859085203",
				value = textField4.value,
				onValueChange = { newText -> textField4.value = newText },
				textStyle = TextStyle(
					color = Color(0xFF8796AD),
					fontSize = 14.sp,
				),
				modifier = Modifier
					.padding(bottom = 49.dp,)
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
					.padding(vertical = 15.dp,horizontal = 14.dp,)
			)
			OutlinedButton(
				onClick = { println("Pressed!") },
				border = BorderStroke(0.dp, Color.Transparent),
				colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
				contentPadding = PaddingValues(),
				modifier = Modifier
					.clip(shape = RoundedCornerShape(12.dp))
					.fillMaxWidth()
					.background(
						color = Color(0xFF4F75FF),
						shape = RoundedCornerShape(12.dp)
					)
			){
				Column(
					horizontalAlignment = Alignment.CenterHorizontally,
					modifier = Modifier
						.padding(vertical = 15.dp,)
				){
					Text("Xác nhận",
						color = Color(0xFFFFFFFF),
						fontSize = 16.sp,
					)
				}
			}
}