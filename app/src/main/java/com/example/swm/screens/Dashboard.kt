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
import com.skydoves.landscapist.*
import com.skydoves.landscapist.coil3.*
@Composable
fun 2_Dashboard-HàNgTrongKho() {
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
				.padding(top = 27.dp,)
				.verticalScroll(rememberScrollState())
		){
			Row(
				modifier = Modifier
					.padding(bottom = 20.dp,start = 38.dp,end = 38.dp,)
					.fillMaxWidth()
			){
				Column(
					modifier = Modifier
						.padding(top = 3.dp,end = 4.dp,)
						.weight(1f)
				){
					Text("Have a good day, Thế Kiệt",
						color = Color(0xFF000000),
						fontSize = 12.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.padding(bottom = 9.dp,start = 1.dp,end = 1.dp,)
					)
					Text("Công việc hôm nay của bạn thật tuyệt,  tiếp tục phát huy nhé!",
						color = Color(0xFF000000),
						fontSize = 10.sp,
					)
				}
				CoilImage(
					imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/f2c59e28-1c30-4f2d-860e-b3f02ae3fb87"},
					imageOptions = ImageOptions(contentScale = ContentScale.Crop),
					modifier = Modifier
						.width(27.dp)
						.height(27.dp)
				)
			}
			Row(
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.padding(bottom = 37.dp,start = 28.dp,end = 28.dp,)
					.fillMaxWidth()
			){
				OutlinedButton(
					onClick = { println("Pressed!") },
					border = BorderStroke(0.dp, Color.Transparent),
					colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
					contentPadding = PaddingValues(),
					modifier = Modifier
						.clip(shape = RoundedCornerShape(80.dp))
						.width(91.dp)
						.background(
							color = Color(0xFF4F75FF),
							shape = RoundedCornerShape(80.dp)
						)
				){
					Column(
						horizontalAlignment = Alignment.CenterHorizontally,
						modifier = Modifier
							.padding(vertical = 11.dp,)
					){
						Text("Hàng trong kho",
							color = Color(0xFFFFFFFF),
							fontSize = 10.sp,
							fontWeight = FontWeight.Bold,
						)
					}
				}
				OutlinedButton(
					onClick = { println("Pressed!") },
					border = BorderStroke(0.dp, Color.Transparent),
					colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
					contentPadding = PaddingValues(),
					modifier = Modifier
						.border(
							width = 1.dp,
							color = Color(0xFFC2BFBF),
							shape = RoundedCornerShape(80.dp)
						)
						.clip(shape = RoundedCornerShape(80.dp))
						.width(91.dp)
				){
					Column(
						horizontalAlignment = Alignment.CenterHorizontally,
						modifier = Modifier
							.padding(vertical = 10.dp,)
					){
						Text("Vận chuyển",
							color = Color(0xFF000000),
							fontSize = 10.sp,
						)
					}
				}
				OutlinedButton(
					onClick = { println("Pressed!") },
					border = BorderStroke(0.dp, Color.Transparent),
					colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
					contentPadding = PaddingValues(),
					modifier = Modifier
						.border(
							width = 1.dp,
							color = Color(0xFFC2BFBF),
							shape = RoundedCornerShape(80.dp)
						)
						.clip(shape = RoundedCornerShape(80.dp))
						.width(133.dp)
				){
					Column(
						horizontalAlignment = Alignment.CenterHorizontally,
						modifier = Modifier
							.padding(vertical = 10.dp,)
					){
						Text("Số lượng hàng cần nhập",
							color = Color(0xFF000000),
							fontSize = 10.sp,
						)
					}
				}
			}
			Column(
				modifier = Modifier
					.padding(bottom = 44.dp,start = 28.dp,end = 28.dp,)
					.clip(shape = RoundedCornerShape(12.dp))
					.fillMaxWidth()
					.background(
						color = Color(0xFFF4F5F7),
						shape = RoundedCornerShape(12.dp)
					)
					.padding(vertical = 13.dp,horizontal = 33.dp,)
			){
				Row(
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier
						.padding(bottom = 5.dp,)
						.fillMaxWidth()
				){
					Text("Hàng trong kho",
						color = Color(0xFF000000),
						fontSize = 17.sp,
						modifier = Modifier
							.padding(end = 4.dp,)
							.weight(1f)
					)
					CoilImage(
						imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/87baf8b8-11fa-49f6-b0ac-c0769657cf96"},
						imageOptions = ImageOptions(contentScale = ContentScale.Crop),
						modifier = Modifier
							.width(30.dp)
							.height(28.dp)
					)
				}
				Text("250",
					color = Color(0xFF4F75FF),
					fontSize = 22.sp,
					fontWeight = FontWeight.Bold,
					modifier = Modifier
						.padding(bottom = 8.dp,)
				)
				Row(
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier
						.fillMaxWidth()
				){
					Column(
						modifier = Modifier
							.padding(end = 28.dp,)
							.clip(shape = RoundedCornerShape(5.dp))
							.width(28.dp)
							.background(
								color = Color(0xFFC0F4CD),
								shape = RoundedCornerShape(5.dp)
							)
							.padding(horizontal = 5.dp,)
					){
						CoilImage(
							imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/0de3c262-3086-4b9e-a2b9-8c9c943e2460"},
							imageOptions = ImageOptions(contentScale = ContentScale.Crop),
							modifier = Modifier
								.padding(top = 4.dp,)
								.height(14.dp)
								.fillMaxWidth()
						)
					}
					Text("20% so với tháng trước",
						color = Color(0xFF000000),
						fontSize = 17.sp,
						modifier = Modifier
							.weight(1f)
					)
				}
			}
			Text("Trạng thái trong tuần",
				color = Color(0xFF343C6A),
				fontSize = 12.sp,
				fontWeight = FontWeight.Bold,
				modifier = Modifier
					.padding(bottom = 16.dp,start = 38.dp,)
			)
			Column(
				modifier = Modifier
					.padding(bottom = 133.dp,)
					.fillMaxWidth()
					.background(
						color = Color(0xFFFFFFFF),
					)
					.padding(vertical = 22.dp,)
			){
				Row(
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier
						.padding(bottom = 20.dp,start = 38.dp,end = 38.dp,)
						.height(10.dp)
						.fillMaxWidth()
				){
					CoilImage(
						imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/c4acb885-7bca-4c98-9c81-414692a195c3"},
						imageOptions = ImageOptions(contentScale = ContentScale.Crop),
						modifier = Modifier
							.padding(end = 14.dp,)
							.width(9.dp)
							.height(9.dp)
					)
					Text("Import",
						color = Color(0xFF718EBF),
						fontSize = 10.sp,
					)
					Column(
						modifier = Modifier
							.weight(1f)
					){
					}
					CoilImage(
						imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/9e4eb0f1-d068-4c3b-8314-390bd8ae50f3"},
						imageOptions = ImageOptions(contentScale = ContentScale.Crop),
						modifier = Modifier
							.padding(end = 14.dp,)
							.width(9.dp)
							.height(9.dp)
					)
					Text("Export",
						color = Color(0xFF718EBF),
						fontSize = 10.sp,
					)
				}
				Row(
					horizontalArrangement = Arrangement.SpaceBetween,
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier
						.padding(bottom = 11.dp,start = 15.dp,end = 15.dp,)
						.fillMaxWidth()
				){
					Column(
						modifier = Modifier
							.width(18.dp)
					){
						Text("500",
							color = Color(0xFF718EBF),
							fontSize = 10.sp,
							modifier = Modifier
								.padding(bottom = 17.dp,)
						)
						Text("400",
							color = Color(0xFF718EBF),
							fontSize = 10.sp,
							modifier = Modifier
								.padding(bottom = 18.dp,)
						)
						Text("300",
							color = Color(0xFF718EBF),
							fontSize = 10.sp,
							modifier = Modifier
								.padding(bottom = 18.dp,)
						)
						Text("200",
							color = Color(0xFF718EBF),
							fontSize = 10.sp,
							modifier = Modifier
								.padding(bottom = 18.dp,)
						)
						Text("100",
							color = Color(0xFF718EBF),
							fontSize = 10.sp,
							modifier = Modifier
								.padding(bottom = 17.dp,)
						)
						Text("0",
							color = Color(0xFF718EBF),
							fontSize = 10.sp,
							modifier = Modifier
								.padding(horizontal = 3.dp,)
						)
					}
					Column(
						modifier = Modifier
							.width(361.dp)
					){
						Column(
							modifier = Modifier
								.padding(bottom = 4.dp,)
								.height(1.dp)
								.fillMaxWidth()
								.background(
									color = Color(0xFFF3F3F5),
								)
						){
						}
						Column(
							modifier = Modifier
								.fillMaxWidth()
						){
							Column(
								modifier = Modifier
									.padding(horizontal = 14.dp,)
									.width(8.dp)
									.height(133.dp)
									.background(
										color = Color(0xFF1814F3),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 169.dp,)
									.width(8.dp)
									.height(133.dp)
									.background(
										color = Color(0xFF1814F3),
									)
							){
							}
							Column(
								modifier = Modifier
									.height(1.dp)
									.fillMaxWidth()
									.background(
										color = Color(0xFFF3F3F5),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 30.dp,)
									.height(110.dp)
									.fillMaxWidth()
									.background(
										color = Color(0xFF1814F3),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 82.dp,)
									.height(109.dp)
									.fillMaxWidth()
									.background(
										color = Color(0xFF1814F3),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 169.dp,)
									.height(103.dp)
									.fillMaxWidth()
									.background(
										color = Color(0xFF16DBCC),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 66.dp,)
									.width(8.dp)
									.height(97.dp)
									.background(
										color = Color(0xFF1814F3),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 15.dp,)
									.height(94.dp)
									.fillMaxWidth()
									.background(
										color = Color(0xFF16DBCC),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 117.dp,)
									.width(8.dp)
									.height(91.dp)
									.background(
										color = Color(0xFF1814F3),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(bottom = 9.dp,)
									.height(1.dp)
									.fillMaxWidth()
									.background(
										color = Color(0xFFF3F3F5),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 133.dp,)
									.width(8.dp)
									.height(73.dp)
									.background(
										color = Color(0xFF16DBCC),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 30.dp,)
									.width(8.dp)
									.height(68.dp)
									.background(
										color = Color(0xFF16DBCC),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 118.dp,)
									.height(68.dp)
									.fillMaxWidth()
									.background(
										color = Color(0xFF16DBCC),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 67.dp,)
									.height(68.dp)
									.fillMaxWidth()
									.background(
										color = Color(0xFF16DBCC),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(bottom = 12.dp,)
									.height(1.dp)
									.fillMaxWidth()
									.background(
										color = Color(0xFFF3F3F5),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 134.dp,)
									.height(42.dp)
									.fillMaxWidth()
									.background(
										color = Color(0xFF1814F3),
									)
							){
							}
							Column(
								modifier = Modifier
									.padding(horizontal = 81.dp,)
									.width(8.dp)
									.height(36.dp)
									.background(
										color = Color(0xFF16DBCC),
									)
							){
							}
							Column(
								modifier = Modifier
									.height(1.dp)
									.fillMaxWidth()
									.background(
										color = Color(0xFFF3F3F5),
									)
							){
							}
						}
						Column(
							modifier = Modifier
								.height(1.dp)
								.fillMaxWidth()
								.background(
									color = Color(0xFFF3F3F5),
								)
						){
						}
					}
				}
				Row(
					horizontalArrangement = Arrangement.SpaceBetween,
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier
						.padding(horizontal = 36.dp,)
						.fillMaxWidth()
				){
					Text("Sat",
						color = Color(0xFF718EBF),
						fontSize = 10.sp,
					)
					Text("Sun",
						color = Color(0xFF718EBF),
						fontSize = 10.sp,
					)
					Text("Mon",
						color = Color(0xFF718EBF),
						fontSize = 10.sp,
					)
					Text("Tue",
						color = Color(0xFF718EBF),
						fontSize = 10.sp,
					)
					Text("Wed",
						color = Color(0xFF718EBF),
						fontSize = 10.sp,
					)
					Text("Thu",
						color = Color(0xFF718EBF),
						fontSize = 10.sp,
					)
					Text("Fri",
						color = Color(0xFF718EBF),
						fontSize = 10.sp,
					)
				}
			}
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.clip(shape = RoundedCornerShape(75.dp))
					.fillMaxWidth()
					.background(
						color = Color(0xFFFFFFFF),
						shape = RoundedCornerShape(75.dp)
					)
					.padding(vertical = 15.dp,horizontal = 16.dp,)
			){
				OutlinedButton(
					onClick = { println("Pressed!") },
					border = BorderStroke(0.dp, Color.Transparent),
					colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
					contentPadding = PaddingValues(),
					modifier = Modifier
						.padding(end = 65.dp,)
						.clip(shape = RoundedCornerShape(44.dp))
						.width(102.dp)
						.background(
							color = Color(0xFF4F75FF),
							shape = RoundedCornerShape(44.dp)
						)
				){
					Row(
						horizontalArrangement = Arrangement.Center,
						verticalAlignment = Alignment.CenterVertically,
						modifier = Modifier
							.padding(vertical = 12.dp,)
					){
						CoilImage(
							imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/8e9342e9-ec4b-4b5e-9213-2c0e36bd85ae"},
							imageOptions = ImageOptions(contentScale = ContentScale.Crop),
							modifier = Modifier
								.padding(end = 8.dp,)
								.width(24.dp)
								.height(24.dp)
						)
						Text("Home",
							color = Color(0xFFFFFFFF),
							fontSize = 12.sp,
							fontWeight = FontWeight.Bold,
						)
					}
				}
				CoilImage(
					imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/d87ab1f0-6b28-4ded-a951-022377ff3e32"},
					imageOptions = ImageOptions(contentScale = ContentScale.Crop),
					modifier = Modifier
						.padding(end = 73.dp,)
						.width(24.dp)
						.height(24.dp)
				)
				CoilImage(
					imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/4aba96be-524b-44da-8b16-2e0098fc2f3d"},
					imageOptions = ImageOptions(contentScale = ContentScale.Crop),
					modifier = Modifier
						.padding(end = 74.dp,)
						.width(24.dp)
						.height(24.dp)
				)
				CoilImage(
					imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/20256092-0494-4eae-8db2-ebfda628b8d1"},
					imageOptions = ImageOptions(contentScale = ContentScale.Crop),
					modifier = Modifier
						.width(24.dp)
						.height(24.dp)
				)
			}
		}
	}
}