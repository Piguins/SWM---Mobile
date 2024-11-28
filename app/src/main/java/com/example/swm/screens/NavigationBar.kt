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
fun NavigationBar() {
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
                .dashedBorder(
                    width = 1.dp,
                    color = Color(0xFF9747FF),
                    dashWidth = 10.dp,
                    gapWidth = 4.dp,
                    shape = RoundedCornerShape(5.dp)
                )
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 35.dp,)
                .verticalScroll(rememberScrollState())
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 95.dp,start = 36.dp,end = 36.dp,)
                    .fillMaxWidth()
            ){
                OutlinedButton(
                    onClick = { },
                    border = BorderStroke(0.dp, Color.Transparent),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                    contentPadding = PaddingValues(),
                    modifier = Modifier
                        .padding(end = 65.dp,)
                        .clip(shape = RoundedCornerShape(44.dp))
                        .width(102.dp)
                        .background(
                            color = Color(0xFF613EEA),
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
                            imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/8968677b-145f-4e24-b615-1dbe29141c41"},
                            imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                            modifier = Modifier
                                .padding(end = 8.dp,)
                                .width(24.dp)
                                .height(24.dp)
                        )
                        Text("Home",
                            color = MyColors.surfaceContainerLowest,
                            fontSize = MyFontSize.body_small,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                CoilImage(
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/b3d7972e-f45f-4e02-8e59-1a86cda0f9e3"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .padding(end = 73.dp,)
                        .width(24.dp)
                        .height(24.dp)
                )
                CoilImage(
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/ecf9e628-b1f7-4e73-ae17-34b3bc63639f"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .padding(end = 74.dp,)
                        .width(24.dp)
                        .height(24.dp)
                )
                CoilImage(
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/81cb3284-1667-4de7-a639-2c48625505ca"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 111.dp,start = 46.dp,end = 46.dp,)
                    .height(24.dp)
                    .fillMaxWidth()
            ){
                CoilImage(
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/762de297-2825-4161-93ef-deb733683231"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .padding(end = 60.dp,)
                        .width(24.dp)
                        .height(24.dp)
                )
                OutlinedButton(
                    onClick = { },
                    border = BorderStroke(0.dp, Color.Transparent),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                    contentPadding = PaddingValues(),
                    modifier = Modifier
                        .padding(end = 59.dp,)
                        .clip(shape = RoundedCornerShape(44.dp))
                        .width(115.dp)
                        .background(
                            color = Color(0xFF613EEA),
                            shape = RoundedCornerShape(44.dp)
                        )
                ){
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 10.dp,)
                    ){
                        CoilImage(
                            imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/afda3f3a-6d1b-4cb5-9f9a-04afa4ac129e"},
                            imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                            modifier = Modifier
                                .padding(end = 7.dp,)
                                .width(24.dp)
                                .height(24.dp)
                        )
                        Text("Product",
                            color = MyColors.surfaceContainerLowest,
                            fontSize = MyFontSize.body_small,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                CoilImage(
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/584013a8-c0fd-4e6e-9f73-ba61aca352c7"},
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
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/a805ba9e-5272-4695-9a5b-886a8cce4e6f"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 108.dp,start = 46.dp,end = 46.dp,)
                    .height(24.dp)
                    .fillMaxWidth()
            ){
                CoilImage(
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/040d3064-3ef8-485c-b294-260c8a12aec3"},
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
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/a1017546-e85b-43ac-9b59-d6df5696aa99"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .padding(end = 60.dp,)
                        .width(24.dp)
                        .height(24.dp)
                )
                OutlinedButton(
                    onClick = { },
                    border = BorderStroke(0.dp, Color.Transparent),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                    contentPadding = PaddingValues(),
                    modifier = Modifier
                        .padding(end = 60.dp,)
                        .clip(shape = RoundedCornerShape(44.dp))
                        .width(114.dp)
                        .background(
                            color = Color(0xFF613EEA),
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
                            imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/20554699-6bf2-4b7a-af46-baf5ad149450"},
                            imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                            modifier = Modifier
                                .padding(end = 6.dp,)
                                .width(24.dp)
                                .height(24.dp)
                        )
                        Text("Shipment",
                            color = MyColors.surfaceContainerLowest,
                            fontSize = MyFontSize.body_small,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                CoilImage(
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/6f49491d-87e1-4c5e-8775-89685e0f578f"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 46.dp,)
                    .height(48.dp)
                    .fillMaxWidth()
            ){
                CoilImage(
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/428615ac-748d-4cd5-97bc-6dc639d258bd"},
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
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/ec52a94b-1a50-4aa1-bf99-70a6c8d99798"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .padding(end = 72.dp,)
                        .width(24.dp)
                        .height(24.dp)
                )
                CoilImage(
                    imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/e919496c-6978-47a9-9068-b849be1b8304"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .padding(end = 63.dp,)
                        .width(24.dp)
                        .height(24.dp)
                )
                OutlinedButton(
                    onClick = { },
                    border = BorderStroke(0.dp, Color.Transparent),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                    contentPadding = PaddingValues(),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(44.dp))
                        .width(106.dp)
                        .background(
                            color = Color(0xFF613EEA),
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
                            imageModel = {"https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/20617e34-5a8b-4b97-af82-27a9b2a66133"},
                            imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                            modifier = Modifier
                                .padding(end = 7.dp,)
                                .width(24.dp)
                                .height(24.dp)
                        )
                        Text("Profile",
                            color = MyColors.surfaceContainerLowest,
                            fontSize = MyFontSize.body_small,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
    }
}