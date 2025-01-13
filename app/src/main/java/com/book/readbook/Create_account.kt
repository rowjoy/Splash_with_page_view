package com.book.readbook

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.book.readbook.ui.theme.AppColors

@Composable
fun TextWidget (
    titleText : String
){
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Black, // Set color to black
                    fontSize = 16.sp, // Optional: Adjust font size if needed
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                )
            ){
                append("You ")
            }

            withStyle(
                style = SpanStyle(
                    color = AppColors.buttonColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                )
            ) {
                append(titleText.toUpperCase())
            }

            append("  ") // Add space after "Create"

            // Style for "account please sweep this page" with black color
            withStyle(
                style = SpanStyle(
                    color = Color.Black, // Set color to black
                    fontSize = 16.sp, // Optional: Adjust font size if needed
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                )
            ) {
                append("account please sweep this page")
            }
        }
    )
}