import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.book.readbook.ui.theme.ReadBookTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.flow.collectLatest
import kotlin.math.abs
import com.book.readbook.R

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AnimatedHeightPager () {
    val pagerState = rememberPagerState(initialPage = 0)
    val baseHeight = 450.dp
    var animatedHeight by remember { mutableStateOf(baseHeight) }

    // Observe offset changes
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPageOffset }
            .collectLatest { offset ->
                val  heightChange = (100.dp * abs(offset + pagerState.currentPage))
                animatedHeight = baseHeight + heightChange
                println("Current Offset: $offset, Adjusted Height: $animatedHeight ")
            }
    }

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
        ) { Image(
                painter =  painterResource(id = R.drawable.background_images ),
                contentDescription = "Back images",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp) // Adjust the height as needed
                    .align(Alignment.TopStart)
            )
        }

       Box(modifier = Modifier.fillMaxSize(),
           contentAlignment = Alignment.TopCenter
           ){
            Column {
                Image(
                    painter = painterResource(id = R.drawable.app_logo),
                    contentDescription = "App Logo",
                    modifier = Modifier.size(150.dp)

                )
                Text(text = "Welcome back!",
                     textAlign = TextAlign.Center,
                     color = Color.Black,
                     fontSize = 22.sp,


                    )
                Text(text = "Log in to existing LOGO account",
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontSize = 15.sp,)
            }
       }


    }





    Column(
        modifier = Modifier.fillMaxSize(),
         verticalArrangement = Arrangement.Bottom,
        ) {
        HorizontalPager(
            count = 2,
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            Box (
                modifier = Modifier
                    .height(animatedHeight)
                    .fillMaxWidth()
                    .shadow(
                        elevation = 0.dp,
                        shape = RoundedCornerShape(
                            topStart = if (page == 0) 16.dp else 0.dp, // Top-left corner
                           // topEnd = 16.dp,  // Top-right corner
//                            bottomStart = 0.dp, // Bottom-left corner (no rounding)
//                            bottomEnd = 0.dp   // Bottom-right corner (no rounding)
                        ),
                        clip = false

                    )

                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(
                            topStart = if(page == 0) 16.dp else 0.dp,
                           // topEnd = 16.dp
                        )
                        ),
            ) {

            }
        }
    }
}



@ExperimentalPagerApi
fun calculateCurrentPageOffsetFraction(pagerState: PagerState): Float {
    return (pagerState.currentPage + pagerState.currentPageOffset).toFloat()
}

@Preview(showBackground = true)
@Composable
fun PreviewComposeAnimationHight (){
   ReadBookTheme {
       Surface {
           AnimatedHeightPager ()
       }
   }
}

