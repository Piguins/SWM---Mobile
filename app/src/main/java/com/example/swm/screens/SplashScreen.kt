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
@Composable
fun 0_SplashScreen() {
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
                .padding(top = 401.dp,start = 147.dp,end = 147.dp,)
                .verticalScroll(rememberScrollState())
        ){
            Text("Storix",
                color = Color(0xFF4F75FF),
                fontSize = 45.sp,
                modifier = Modifier
                    .padding(bottom = 385.dp,)
            )
            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(100.dp))
                    .height(5.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(100.dp)
                    )
            ){
            }
        }
    }
}
