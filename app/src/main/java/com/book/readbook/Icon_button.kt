package com.book.readbook

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun CustomIconButton (
    onClick: () -> Unit,
    @DrawableRes id: Int
){
    IconButton(
        onClick = onClick) {
        Icon(
            painter = painterResource(id = id),
            contentDescription =  "FaceBook",
            tint = Color.Unspecified
        )
    }

}