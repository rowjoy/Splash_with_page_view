

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.book.readbook.R
import com.book.readbook.ui.theme.AppColors
import com.book.readbook.ui.theme.ReadBookTheme
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import java.util.Locale


@Composable

//navController : NavController
fun  SplashViews (navController : NavController){
//
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            isNavigationBarContrastEnforced = false,
            color = Color.Transparent,
            darkIcons = true
        )
    }



    val initialHeight = 0.dp
    val targetHeight = 300.dp

    var animatedHeight by remember { mutableStateOf(initialHeight)}
    val animationHeight by animateDpAsState(
        targetValue = animatedHeight,
        animationSpec = tween(durationMillis = 1500, easing = FastOutSlowInEasing)
    )


    LaunchedEffect(Unit) {
        animatedHeight = targetHeight
        kotlinx.coroutines.delay(2000) // 3-second delay
        navController.navigate("pager") {
            popUpTo("splash") { inclusive = true }
        }

    }



    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
       // verticalArrangement = Arrangement.Center,
    ) {

        Row (
            modifier = Modifier.padding(top = 0.dp, start = 30.dp)
        ) {
            DrawLines(animationHeight = animationHeight, y = 700f)
            Spacer(modifier = Modifier.width(100.dp))
            DrawLines(animationHeight = animationHeight - 50.dp, y = 640f)
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(220.dp)

            )

        }

        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {

            Image(
                alignment = Alignment.Center,
                painter = painterResource(id = R.drawable.center_images),
                contentDescription = "Center images",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(animationHeight)
            )

            Column {
                Text(
                    text = "Lorem Ipsum".toUpperCase(Locale.ROOT),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Lorem Ipsum is a dummy text used as placeholder in app logo",
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.fillMaxWidth()
                )
            }


        }
    }
}




@Composable
fun DrawLines ( animationHeight : Dp,  y: Float){
    Canvas(
        modifier = Modifier
            .width(3.dp)
            .height(animationHeight)
    ) {
        drawLine(
            color = AppColors.S_lineColor,
            start = this.center.copy(y = 0f),
            end = this.center.copy(y = size.height),
            strokeWidth = 4f,
        )

//        drawCircle(
//            color = AppColors.S_lineColor,
//            radius = if(animationHeight > 200.dp)  50f else 0f,
//            center = androidx.compose.ui.geometry.Offset(0f,   y),
//            style = Stroke(width = 100f) // Change to `Fill` if you want a solid circle
//        )
    }
}



@Preview (showBackground = true)
@Composable
fun SplashViewPre (){
    val navController = rememberNavController()
    ReadBookTheme {
        Surface {
           SplashViews(navController = navController)
        }
    }
}


//https://www.figma.com/design/5nopydudHCKlpGEG1YH56o/Modern-Authentication-App-UI-Kit%3A-Splash%2C-Sign-Up%2C-and-Sign-In-Screens-(Community)?node-id=0-1&p=f&t=7RX1TzkzqG3zRZRr-0