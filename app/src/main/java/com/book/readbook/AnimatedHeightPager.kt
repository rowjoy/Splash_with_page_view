package com.book.readbook

import androidx.compose.material3.Text
import androidx.compose.ui.text.style.LineHeightStyle


import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState





@OptIn(ExperimentalPagerApi::class)
@Composable
fun AnimatedHeightPager() {
    val pagerState = rememberPagerState() // State for pager
    val pageCount = 2

    // Define page heights
    val heights = listOf(200.dp, 300.dp)

    // Animate the height based on the current page
    val animatedHeight by animateDpAsState(
        targetValue = heights[pagerState.currentPage], // Update the height dynamically
        animationSpec = tween(durationMillis = 500) // Animation duration
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(animatedHeight)
    ) {
        HorizontalPager(
            state = pagerState,
            count = pageCount,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(if (page == 0) Color.Red else Color.Blue)
            ) {
                Text(
                    text = "Page ${page + 1}",
                    color = Color.White,
                   // modifier = Modifier.align(LineHeightStyle.Alignment.Center)
                )
            }
        }
    }
}
