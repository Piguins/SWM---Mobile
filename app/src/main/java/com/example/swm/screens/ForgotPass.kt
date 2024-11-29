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
import androidx.compose.foundation.text.*
@Composable
fun 1_1QuêNMậTKhẩU() {
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
                .padding(top = 38.dp,start = 43.dp,end = 43.dp,)
                .verticalScroll(rememberScrollState())
        ){
            Column(
                modifier = Modifier
                    .padding(bottom = 27.dp,)
                    .clip(shape = RoundedCornerShape(90.dp))
                    .width(28.dp)
                    .height(28.dp)
                    .background(
                        color = Color(0xFF4F75FF),
                        shape = RoundedCornerShape(90.dp)
                    )
                    .padding(horizontal = 4.dp,)
            ){
                CoilImage(
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/760485e6-2245-4015-a217-cf9edefed722"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .padding(top = 5.dp,)
                        .height(18.dp)
                        .fillMaxWidth()
                )
            }
            Column(
                modifier = Modifier
                    .padding(bottom = 79.dp,)
                    .fillMaxWidth()
            ){
                Box(
                    modifier = Modifier
                        .padding(bottom = 5.dp,)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        CoilImage(
                            imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/c50e5d53-8395-4b50-a0fc-fc0cd2afd50d"},
                            imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                            modifier = Modifier
                                .height(198.dp)
                                .fillMaxWidth()
                        )
                    }
                    CoilImage(
                        imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/a3f1861c-2939-47e5-ab30-4d55bffdc87a"},
                        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                        modifier = Modifier
                            .offset(x = -93.dp, y = 11.dp)
                            .align(Alignment.BottomEnd)
                            .padding(bottom = 11.dp)
                            .width(60.dp)
                            .height(167.dp)
                    )
                }
                CoilImage(
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/81875d8f-1bb1-4ef7-8b94-a7dc1ea46a58"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .padding(horizontal = 38.dp,)
                        .height(13.dp)
                        .fillMaxWidth()
                )
            }
            Text("Email",
                color = Color(0xFF0B1420),
                fontSize = MyFontSize.body_medium,
                modifier = Modifier
                    .padding(bottom = 7.dp,)
            )
            BasicTextField(
                value = "Example@email.com",
                onValueChange = { },
                textStyle = TextStyle(
                    color = Color(0xFF8796AD),
                    fontSize = MyFontSize.body_medium,
                ),
                modifier = Modifier
                    .padding(bottom = 52.dp,)
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
                    .padding(15.dp)
            )
            OutlinedButton(
                onClick = { },
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
                        color = MyColors.surfaceContainerLowest,
                        fontSize = MyFontSize.body_large,
                    )
                }
            }
        }
    }
}