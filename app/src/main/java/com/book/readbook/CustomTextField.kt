package com.book.readbook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.book.readbook.ui.theme.AppColors
import com.book.readbook.ui.theme.ReadBookTheme
import com.book.readbook.ui.theme.Shapes

@Composable
fun CustomTextField (
     labelName : String,
     value: String,
     leadingImageVector: ImageVector,
     onValueChange: (String) -> Unit,
     keyboardType: KeyboardType

){

    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        maxLines = 1,
        minLines = 1,
        shape = Shapes.medium,
        value = value ,
        visualTransformation = VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),

        leadingIcon = {
            Icon(imageVector = leadingImageVector, contentDescription = "Email")
        },
        onValueChange = onValueChange,
        label = {
            Text(text = labelName)
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            unfocusedContainerColor = AppColors.textFilled,
            unfocusedLabelColor = AppColors.textFieldText
        )


    )

}






@Preview(showBackground = true)
@Composable
fun  CustomTextFieldPre (){
    ReadBookTheme {
        Column(
            modifier = Modifier.fillMaxSize()

        ) {
            CustomTextField(
                labelName = "Enter email",
                value = "",
                onValueChange = {},
                keyboardType = KeyboardType.Email,
                leadingImageVector = Icons.Filled.Email

            )
        }
    }
}