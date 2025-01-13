import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.book.readbook.CustomButton
import com.book.readbook.CustomIconButton
import com.book.readbook.CustomTextField
import com.book.readbook.ui.theme.ReadBookTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.flow.collectLatest
import kotlin.math.abs
import com.book.readbook.R
import com.book.readbook.TextWidget
import com.book.readbook.ui.theme.AppColors

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AnimatedHeightPager () {
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()
    val baseHeight = 450.dp
    var pageoffset: Float = 1f
    var animatedHeight by remember { mutableStateOf(baseHeight) }

    // Observe offset changes
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPageOffset }
            .collectLatest { offset ->
                pageoffset = if (offset == 0.0f) 1f else offset + pagerState.currentPage
                val  heightChange = (100.dp * abs(offset + pagerState.currentPage))
                animatedHeight = baseHeight + heightChange
                println("Current Offset: $offset, Adjusted Height: $animatedHeight")
            }
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White.copy(alpha = 0.3f))
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
        ) { Image(
                painter =  painterResource(id = R.drawable.back_ground_images),
                contentDescription = "Back images",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp) // Adjust the height as needed
                    .align(Alignment.TopStart)
            )
        }
       Box(modifier = Modifier.fillMaxSize(),
           contentAlignment = Alignment.TopCenter
           ){
            Column {
                Image(
                    painter = painterResource(id = R.drawable.app_logo_pro),
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
                        color = Color.White,
                        shape = RoundedCornerShape(
                            topStart = if (page == 0) 16.dp else 0.dp,
                            // topEnd = 16.dp
                        )
                    ),
            ) {
               Column  (
                  modifier = Modifier
                      .alpha(pageoffset)
                      .padding(15.dp)

               ) {
                   Spacer(modifier = Modifier.height(30.dp))
                  if (page == 0){
                      CustomTextField(
                          labelName = "Enter email",
                          keyboardType = KeyboardType.Email,
                          onValueChange = {},
                          leadingImageVector = Icons.Filled.Email,
                          value = ""
                      )
                      Spacer(modifier = Modifier.height(20.dp))
                      CustomTextField(
                          labelName = "Enter password",
                          keyboardType = KeyboardType.Password,
                          onValueChange = {},
                          leadingImageVector = Icons.Filled.Lock,
                          value = ""
                      )
                      Spacer(modifier = Modifier.height(25.dp))
                      CustomButton(

                          btnName = "Log in",
                          onClick = {}
                      )
                      Spacer(modifier = Modifier.height(30.dp))
                      TextWidget (titleText = "Create")
                      Spacer(modifier = Modifier.height(30.dp))
                      Row (
                          modifier = Modifier.fillMaxWidth(),
                          horizontalArrangement = Arrangement.SpaceEvenly
                      ){
                         CustomIconButton(onClick = { /*TODO*/ }, id = R.drawable.facebook_icon )
                          CustomIconButton(onClick = { /*TODO*/ }, id = R.drawable.google_icon )
                          CustomIconButton(onClick = { /*TODO*/ }, id = R.drawable.apple_icon )
                      }
                  } else {

                      CustomTextField(
                          labelName = "Enter Name",
                          keyboardType = KeyboardType.Text,
                          onValueChange = {},
                          leadingImageVector = Icons.Filled.Person,
                          value = ""
                      )
                      Spacer(modifier = Modifier.height(20.dp))
                      CustomTextField(
                          labelName = "Enter phone number",
                          keyboardType = KeyboardType.Phone,
                          onValueChange = {},
                          leadingImageVector = Icons.Filled.Phone,
                          value = ""
                      )
                      Spacer(modifier = Modifier.height(20.dp))
                      CustomTextField(
                          labelName = "Enter email",
                          keyboardType = KeyboardType.Email,
                          onValueChange = {},
                          leadingImageVector = Icons.Filled.Email,
                          value = ""
                      )
                      Spacer(modifier = Modifier.height(20.dp))
                      CustomTextField(
                          labelName = "Enter password",
                          keyboardType = KeyboardType.Password,
                          onValueChange = {},
                          leadingImageVector = Icons.Filled.Lock,
                          value = ""
                      )
                      Spacer(modifier = Modifier.height(25.dp))
                      CustomButton(

                          btnName = "Create",
                          onClick = {}
                      )
                      Spacer(modifier = Modifier.height(25.dp))
                      TextWidget (titleText = "Log in")
                      Spacer(modifier = Modifier.height(20.dp))
                      Row (
                          modifier = Modifier.fillMaxWidth(),
                          horizontalArrangement = Arrangement.SpaceEvenly
                      ){
                          CustomIconButton(onClick = { /*TODO*/ }, id = R.drawable.facebook_icon )
                          CustomIconButton(onClick = { /*TODO*/ }, id = R.drawable.google_icon )
                          CustomIconButton(onClick = { /*TODO*/ }, id = R.drawable.apple_icon )
                      }

                  }
               }
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
fun PreviewComposeAnimationHeight (){
   ReadBookTheme {
       Surface {
           AnimatedHeightPager ()
       }
   }
}

