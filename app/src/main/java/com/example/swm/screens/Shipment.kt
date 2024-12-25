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
fun 4_Shipment() {
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
				.padding(top = 42.dp,)
				.verticalScroll(rememberScrollState())
		){
			Row(
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.padding(bottom = 32.dp,start = 30.dp,end = 30.dp,)
					.fillMaxWidth()
			){
				Row(
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier
						.border(
							width = 1.dp,
							color = Color(0xFFE1F2FF),
							shape = RoundedCornerShape(12.dp)
						)
						.clip(shape = RoundedCornerShape(12.dp))
						.width(303.dp)
						.background(
							color = Color(0xFFE1F2FF),
							shape = RoundedCornerShape(12.dp)
						)
						.padding(vertical = 8.dp,horizontal = 17.dp,)
				){
					CoilImage(
						imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/c61fca75-585d-4166-a8fc-a91dc84ff042"},
						imageOptions = ImageOptions(contentScale = ContentScale.Crop),
						modifier = Modifier
							.padding(end = 30.dp,)
							.width(25.dp)
							.height(25.dp)
					)
					Text("Tìm kiếm",
						color = Color(0xFFAEC0FF),
						fontSize = 15.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.weight(1f)
					)
				}
				CoilImage(
					imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/b64ffec3-9535-4b7f-a522-955934f14ec7"},
					imageOptions = ImageOptions(contentScale = ContentScale.Crop),
					modifier = Modifier
						.width(30.dp)
						.height(30.dp)
				)
			}
			Column(
				modifier = Modifier
					.padding(bottom = 27.dp,start = 30.dp,end = 30.dp,)
					.clip(shape = RoundedCornerShape(12.dp))
					.fillMaxWidth()
					.background(
						color = Color(0xFF4F75FF),
						shape = RoundedCornerShape(12.dp)
					)
					.padding(top = 19.dp,)
			){
				Text("Tra cứu tình trạng vận chuyển",
					color = Color(0xFFFFFFFF),
					fontSize = 20.sp,
					fontWeight = FontWeight.Bold,
					modifier = Modifier
						.padding(bottom = 12.dp,start = 20.dp,end = 20.dp,)
				)
				Box(
					modifier = Modifier
						.padding(horizontal = 9.dp,)
				){
					Row(
						horizontalArrangement = Arrangement.SpaceBetween,
						modifier = Modifier
							.fillMaxWidth()
					){
						OutlinedButton(
							onClick = { println("Pressed!") },
							border = BorderStroke(0.dp, Color.Transparent),
							colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
							contentPadding = PaddingValues(),
							modifier = Modifier
								.padding(top = 66.dp,)
								.clip(shape = RoundedCornerShape(8.dp))
								.width(82.dp)
								.background(
									color = Color(0xFFFFFFFF),
									shape = RoundedCornerShape(8.dp)
								)
						){
							Column(
								horizontalAlignment = Alignment.CenterHorizontally,
								modifier = Modifier
									.padding(vertical = 9.dp,)
							){
								Text("Tra cứu",
									color = Color(0xFF000000),
									fontSize = 12.sp,
									fontWeight = FontWeight.Bold,
								)
							}
						}
						Box(
							modifier = Modifier
								.padding(top = 18.dp,)
						){
							Row(
								horizontalArrangement = Arrangement.Center,
								verticalAlignment = Alignment.CenterVertically,
								modifier = Modifier
									.clip(shape = RoundedCornerShape(20.dp))
									.width(152.dp)
									.height(97.dp)
									.padding(vertical = 7.dp,)
							){
								Column(
									modifier = Modifier
										.padding(end = 1.dp,)
										.width(20.dp)
								){
									CoilImage(
										imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/96d96f63-d894-4fa9-9d52-54d2a763c2e6"},
										imageOptions = ImageOptions(contentScale = ContentScale.Crop),
										modifier = Modifier
											.padding(bottom = 13.dp,start = 2.dp,end = 2.dp,)
											.clip(shape = RoundedCornerShape(20.dp))
											.height(20.dp)
											.fillMaxWidth()
									)
									Column(
										modifier = Modifier
											.padding(bottom = 11.dp,)
											.fillMaxWidth()
									){
										Column(
											modifier = Modifier
												.clip(shape = RoundedCornerShape(20.dp))
												.fillMaxWidth()
												.background(
													color = Color(0xFFFFFFFF),
													shape = RoundedCornerShape(20.dp)
												)
												.padding(horizontal = 2.dp,)
										){
											CoilImage(
												imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/18c953d8-3ae4-4fd1-a7c4-6bf2acb65d0c"},
												imageOptions = ImageOptions(contentScale = ContentScale.Crop),
												modifier = Modifier
													.padding(top = 2.dp,)
													.clip(shape = RoundedCornerShape(20.dp))
													.height(6.dp)
													.fillMaxWidth()
											)
										}
										Column(
											modifier = Modifier
												.clip(shape = RoundedCornerShape(20.dp))
												.height(9.dp)
												.fillMaxWidth()
												.background(
													color = Color(0xFFD4E8FC),
													shape = RoundedCornerShape(20.dp)
												)
										){
										}
									}
									CoilImage(
										imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/6e1173c4-7d89-4ae7-b552-864176f7b40f"},
										imageOptions = ImageOptions(contentScale = ContentScale.Crop),
										modifier = Modifier
											.clip(shape = RoundedCornerShape(20.dp))
											.height(29.dp)
											.fillMaxWidth()
									)
								}
								Row(
									horizontalArrangement = Arrangement.SpaceBetween,
									modifier = Modifier
										.width(110.dp)
										.padding(end = 16.dp,)
								){
									Box(
										modifier = Modifier
											.padding(top = 1.dp,)
									){
										Column(
											modifier = Modifier
												.width(43.dp)
										){
											CoilImage(
												imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/5505dfcf-0a62-4a02-8438-ec059765af8e"},
												imageOptions = ImageOptions(contentScale = ContentScale.Crop),
												modifier = Modifier
													.clip(shape = RoundedCornerShape(20.dp))
													.height(89.dp)
													.fillMaxWidth()
											)
										}
										CoilImage(
											imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/23abc69e-8c29-44a5-9adc-a6cdbf6c30a4"},
											imageOptions = ImageOptions(contentScale = ContentScale.Crop),
											modifier = Modifier
												.offset(x = -2.dp, y = 0.dp)
												.align(Alignment.BottomStart)
												.clip(shape = RoundedCornerShape(20.dp))
												.width(10.dp)
												.height(29.dp)
										)
									}
									Column(
										modifier = Modifier
											.clip(shape = RoundedCornerShape(20.dp))
											.width(25.dp)
											.background(
												color = Color(0xFFFFFFFF),
												shape = RoundedCornerShape(20.dp)
											)
											.padding(horizontal = 2.dp,)
									){
										CoilImage(
											imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/e106cf59-c080-43af-bc8e-1c5559339ab9"},
											imageOptions = ImageOptions(contentScale = ContentScale.Crop),
											modifier = Modifier
												.padding(top = 2.dp,)
												.clip(shape = RoundedCornerShape(20.dp))
												.height(8.dp)
												.fillMaxWidth()
										)
									}
									CoilImage(
										imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/79aa9133-ae01-445a-a291-151a60530e2c"},
										imageOptions = ImageOptions(contentScale = ContentScale.Crop),
										modifier = Modifier
											.padding(top = 9.dp,)
											.clip(shape = RoundedCornerShape(20.dp))
											.width(7.dp)
											.height(9.dp)
									)
								}
							}
							Column(
								modifier = Modifier
									.offset(x = 52.dp, y = -18.dp)
									.align(Alignment.BottomStart)
									.padding(start = 52.dp)
									.clip(shape = RoundedCornerShape(20.dp))
									.width(17.dp)
									.height(8.dp)
									.background(
										color = Color(0xFFFFFFFF),
										shape = RoundedCornerShape(20.dp)
									)
									.padding(horizontal = 2.dp,)
							){
								CoilImage(
									imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/2fdcabab-55fe-42b6-be5c-a5813f137d2c"},
									imageOptions = ImageOptions(contentScale = ContentScale.Crop),
									modifier = Modifier
										.padding(top = 1.dp,)
										.clip(shape = RoundedCornerShape(20.dp))
										.height(5.dp)
										.fillMaxWidth()
								)
							}
							CoilImage(
								imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/90d4c504-2912-4845-a6f0-a3ec89a4632f"},
								imageOptions = ImageOptions(contentScale = ContentScale.Crop),
								modifier = Modifier
									.offset(x = -20.dp, y = 20.dp)
									.align(Alignment.TopEnd)
									.padding(bottom = 20.dp)
									.clip(shape = RoundedCornerShape(20.dp))
									.width(48.dp)
									.height(23.dp)
							)
						}
					}
					Text("Tra cứu ngay tình trạng vận chuyển của đơn hàng xuất kho của bạn",
						color = Color(0xFFFFFFFF),
						fontSize = 12.sp,
						modifier = Modifier
							.offset(x = 0.dp, y = 0.dp)
							.align(Alignment.TopStart)
							.width(181.dp)
					)
				}
				Column(
					modifier = Modifier
						.clip(shape = RoundedCornerShape(20.dp))
						.height(1.dp)
						.fillMaxWidth()
						.background(
							color = Color(0xFF152E60),
							shape = RoundedCornerShape(20.dp)
						)
				){
				}
			}
			Text("Vận chuyển",
				color = Color(0xFF343C6A),
				fontSize = 15.sp,
				fontWeight = FontWeight.Bold,
				modifier = Modifier
					.padding(bottom = 34.dp,start = 31.dp,)
			)
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.padding(bottom = 22.dp,start = 30.dp,end = 30.dp,)
					.fillMaxWidth()
			){
				Column(
					modifier = Modifier
						.padding(end = 28.dp,)
						.clip(shape = RoundedCornerShape(topStart = 9.dp,topEnd = 25.dp,bottomStart = 9.dp,bottomEnd = 9.dp,))
						.width(62.dp)
						.background(
							color = Color(0xFFE1F2FF),
							shape = RoundedCornerShape(topStart = 9.dp,topEnd = 25.dp,bottomStart = 9.dp,bottomEnd = 9.dp,)
						)
						.padding(vertical = 15.dp,horizontal = 14.dp,)
				){
					Text("9 Sep",
						color = Color(0xFF000000),
						fontSize = 12.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.padding(bottom = 9.dp,)
					)
					Text("Thu",
						color = Color(0xFF000000),
						fontSize = 12.sp,
					)
				}
				Column(
					modifier = Modifier
						.weight(1f)
				){
					Text("Apple Iphone 12 Plus",
						color = Color(0xFF000000),
						fontSize = 15.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.padding(bottom = 6.dp,)
					)
					Text("Đang vận chuyển",
						color = Color(0xFF000000),
						fontSize = 12.sp,
					)
				}
			}
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.padding(bottom = 22.dp,start = 30.dp,end = 30.dp,)
					.fillMaxWidth()
			){
				Column(
					modifier = Modifier
						.padding(end = 28.dp,)
						.clip(shape = RoundedCornerShape(topStart = 9.dp,topEnd = 25.dp,bottomStart = 9.dp,bottomEnd = 9.dp,))
						.width(62.dp)
						.background(
							color = Color(0xFF4F75FF),
							shape = RoundedCornerShape(topStart = 9.dp,topEnd = 25.dp,bottomStart = 9.dp,bottomEnd = 9.dp,)
						)
						.padding(vertical = 15.dp,horizontal = 14.dp,)
				){
					Text("9 Sep",
						color = Color(0xFFFFFFFF),
						fontSize = 12.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.padding(bottom = 9.dp,)
					)
					Row(
						horizontalArrangement = Arrangement.SpaceBetween,
						verticalAlignment = Alignment.CenterVertically,
						modifier = Modifier
							.fillMaxWidth()
					){
						Text("Thu",
							color = Color(0xFFFFFFFF),
							fontSize = 12.sp,
						)
						CoilImage(
							imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/76c56747-e5d1-45ef-90a2-ee5362e0c080"},
							imageOptions = ImageOptions(contentScale = ContentScale.Crop),
							modifier = Modifier
								.width(8.dp)
								.height(8.dp)
						)
					}
				}
				Column(
					modifier = Modifier
						.weight(1f)
				){
					Text("Samsung Galaxy S24 Ultra Premium",
						color = Color(0xFF000000),
						fontSize = 15.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.padding(bottom = 7.dp,)
					)
					Text("Vận chuyển thành công",
						color = Color(0xFF000000),
						fontSize = 12.sp,
					)
				}
			}
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.padding(bottom = 22.dp,start = 30.dp,end = 30.dp,)
					.fillMaxWidth()
			){
				Column(
					modifier = Modifier
						.padding(end = 28.dp,)
						.clip(shape = RoundedCornerShape(topStart = 9.dp,topEnd = 25.dp,bottomStart = 9.dp,bottomEnd = 9.dp,))
						.width(62.dp)
						.background(
							color = Color(0xFFFF0206),
							shape = RoundedCornerShape(topStart = 9.dp,topEnd = 25.dp,bottomStart = 9.dp,bottomEnd = 9.dp,)
						)
						.padding(vertical = 15.dp,horizontal = 14.dp,)
				){
					Text("9 Sep",
						color = Color(0xFFFFFFFF),
						fontSize = 12.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.padding(bottom = 8.dp,)
					)
					Row(
						horizontalArrangement = Arrangement.SpaceBetween,
						verticalAlignment = Alignment.CenterVertically,
						modifier = Modifier
							.fillMaxWidth()
					){
						Text("Thu",
							color = Color(0xFFFFFFFF),
							fontSize = 12.sp,
						)
						CoilImage(
							imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/2f45c01c-5505-4abb-8e49-49af5a6bf575"},
							imageOptions = ImageOptions(contentScale = ContentScale.Crop),
							modifier = Modifier
								.width(11.dp)
								.height(11.dp)
						)
					}
				}
				Column(
					modifier = Modifier
						.weight(1f)
				){
					Text("Samsung Galaxy S24 Ultra Premium",
						color = Color(0xFF000000),
						fontSize = 15.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.padding(bottom = 7.dp,)
					)
					Text("Vận chuyển thất bại",
						color = Color(0xFF000000),
						fontSize = 12.sp,
					)
				}
			}
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.padding(bottom = 22.dp,start = 30.dp,end = 30.dp,)
					.fillMaxWidth()
			){
				Column(
					modifier = Modifier
						.padding(end = 28.dp,)
						.clip(shape = RoundedCornerShape(topStart = 9.dp,topEnd = 25.dp,bottomStart = 9.dp,bottomEnd = 9.dp,))
						.width(62.dp)
						.background(
							color = Color(0xFFE1F2FF),
							shape = RoundedCornerShape(topStart = 9.dp,topEnd = 25.dp,bottomStart = 9.dp,bottomEnd = 9.dp,)
						)
						.padding(vertical = 15.dp,horizontal = 14.dp,)
				){
					Text("9 Sep",
						color = Color(0xFF000000),
						fontSize = 12.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.padding(bottom = 9.dp,)
					)
					Text("Thu",
						color = Color(0xFF000000),
						fontSize = 12.sp,
					)
				}
				Column(
					modifier = Modifier
						.weight(1f)
				){
					Text("Apple Iphone 12 Plus",
						color = Color(0xFF000000),
						fontSize = 15.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.padding(bottom = 6.dp,)
					)
					Text("Đang vận chuyển",
						color = Color(0xFF000000),
						fontSize = 12.sp,
					)
				}
			}
			Column(
				modifier = Modifier
					.fillMaxWidth()
			){
				Column(
					modifier = Modifier
						.padding(horizontal = 30.dp,)
						.clip(shape = RoundedCornerShape(topStart = 9.dp,topEnd = 25.dp,bottomStart = 9.dp,bottomEnd = 9.dp,))
						.fillMaxWidth()
						.background(
							color = Color(0xFF4F75FF),
							shape = RoundedCornerShape(topStart = 9.dp,topEnd = 25.dp,bottomStart = 9.dp,bottomEnd = 9.dp,)
						)
						.padding(vertical = 15.dp,horizontal = 14.dp,)
				){
					Text("9 Sep",
						color = Color(0xFFFFFFFF),
						fontSize = 12.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.padding(bottom = 9.dp,)
					)
					Row(
						horizontalArrangement = Arrangement.SpaceBetween,
						verticalAlignment = Alignment.CenterVertically,
						modifier = Modifier
							.fillMaxWidth()
					){
						Text("Thu",
							color = Color(0xFFFFFFFF),
							fontSize = 12.sp,
						)
						CoilImage(
							imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/3f3fed02-083c-47f8-9c5f-5465d1d97e0f"},
							imageOptions = ImageOptions(contentScale = ContentScale.Crop),
							modifier = Modifier
								.width(10.dp)
								.height(10.dp)
						)
					}
				}
				Text("Samsung Galaxy S24 Ultra Premium",
					color = Color(0xFF000000),
					fontSize = 15.sp,
					fontWeight = FontWeight.Bold,
					modifier = Modifier
						.padding(bottom = 7.dp,start = 77.dp,end = 77.dp,)
				)
				Text("Vận chuyển thành công",
					color = Color(0xFF000000),
					fontSize = 12.sp,
					modifier = Modifier
						.padding(bottom = 4.dp,start = 120.dp,end = 120.dp,)
				)
				Row(
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier
						.clip(shape = RoundedCornerShape(75.dp))
						.height(24.dp)
						.fillMaxWidth()
						.background(
							color = Color(0xFFFFFFFF),
							shape = RoundedCornerShape(75.dp)
						)
						.padding(vertical = 13.dp,horizontal = 26.dp,)
				){
					CoilImage(
						imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/68532765-62d1-4764-b1cb-24f8f28c264d"},
						imageOptions = ImageOptions(contentScale = ContentScale.Crop),
						modifier = Modifier
							.width(24.dp)
							.height(24.dp)
					)
					Column(
						modifier = Modifier
							.weight(1f)
					){
					}
					CoilImage(
						imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/29b0fb65-5571-46f1-ae27-4e5404f73c1b"},
						imageOptions = ImageOptions(contentScale = ContentScale.Crop),
						modifier = Modifier
							.padding(end = 55.dp,)
							.width(24.dp)
							.height(24.dp)
					)
					OutlinedButton(
						onClick = { println("Pressed!") },
						border = BorderStroke(0.dp, Color.Transparent),
						colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
						contentPadding = PaddingValues(),
						modifier = Modifier
							.padding(end = 54.dp,)
							.clip(shape = RoundedCornerShape(44.dp))
							.width(114.dp)
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
								imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/100e53a8-d8e3-4f1f-a009-3c7608d4edb2"},
								imageOptions = ImageOptions(contentScale = ContentScale.Crop),
								modifier = Modifier
									.padding(end = 6.dp,)
									.width(24.dp)
									.height(24.dp)
							)
							Text("Shipment",
								color = Color(0xFFFFFFFF),
								fontSize = 12.sp,
								fontWeight = FontWeight.Bold,
							)
						}
					}
					CoilImage(
						imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/85b064fe-772e-4865-a451-a00da5d95d1f"},
						imageOptions = ImageOptions(contentScale = ContentScale.Crop),
						modifier = Modifier
							.width(24.dp)
							.height(24.dp)
					)
				}
				Column(
					modifier = Modifier
						.padding(horizontal = 30.dp,)
						.clip(shape = RoundedCornerShape(topStart = 9.dp,topEnd = 25.dp,bottomStart = 9.dp,bottomEnd = 9.dp,))
						.fillMaxWidth()
						.background(
							color = Color(0xFFFF0206),
							shape = RoundedCornerShape(topStart = 9.dp,topEnd = 25.dp,bottomStart = 9.dp,bottomEnd = 9.dp,)
						)
						.padding(top = 36.dp,bottom = 10.dp,start = 14.dp,end = 14.dp,)
				){
					Text("Thu",
						color = Color(0xFFFFFFFF),
						fontSize = 12.sp,
					)
				}
				Text("Vận chuyển thất bại",
					color = Color(0xFF000000),
					fontSize = 12.sp,
					modifier = Modifier
						.padding(horizontal = 120.dp,)
				)
			}
		}
	}
}