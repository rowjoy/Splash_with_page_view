package com.book.readbook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.book.readbook.ui.theme.AppColors
import com.book.readbook.ui.theme.Shapes
import kotlinx.coroutines.launch


@Composable
fun CustomButton (
    btnName : String,
    onClick: () -> Unit
){

    Button(
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Transparent,
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(
                shape = Shapes.medium,
                brush = Brush.linearGradient(
                    colors = listOf(
                        AppColors.buttonColor,
                        AppColors.buttonColor2
                    )
                )
            ),
        shape = Shapes.medium,
        onClick = onClick,
    ) {
        Text(text = btnName.toUpperCase(),
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}