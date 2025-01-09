

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.book.readbook.R
import com.book.readbook.ui.theme.AppColors
import com.book.readbook.ui.theme.ReadBookTheme
import kotlinx.coroutines.delay


@Composable
fun  SplashViews (navController : NavController){
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(3000) // 3-second delay
        navController.navigate("pager") {
            popUpTo("splash") { inclusive = true }
        }
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppColors.backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Column (
            modifier = Modifier.weight(0.3f).padding(20.dp)
        ) {
            Text(text = "Read.Book",

                style = MaterialTheme.typography.titleLarge,
            )
            Text(text = "Digital platform designed to enhance the reading experience by providing access to a variety of books in an organized.")
        }
        Column (
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(id = R.drawable.splash_images) ,
                contentDescription = "Splash images",
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(50.dp))
            CircularProgressIndicator(
                color = AppColors.appFontColor,
                strokeWidth = 3.dp,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )

        }
    }
}


@Preview (showBackground = true)
@Composable
fun SplashViewPre (){
    ReadBookTheme {
        Surface {
           // SplashView()
        }
    }
}