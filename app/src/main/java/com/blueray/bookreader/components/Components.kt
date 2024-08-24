package com.blueray.bookreader.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blueray.bookreader.R


@Composable
fun ReaderLogo(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(16.dp),
        text = stringResource(id = R.string.aReader),
        style = MaterialTheme.typography.headlineLarge,
        color = Color.Red.copy(
            alpha = 0.5f
        )
    )
}



@Composable
fun InputFiled(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
    labelID: String,
    enabled: Boolean = true
) {

    OutlinedTextField(
        value = valueState.value,
        onValueChange = {
            valueState.value = it
        },
        label = {
            Text(text = labelID)
        },
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colorScheme.onBackground),
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
        ),
        keyboardActions = onAction
    )
}


@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    emailState: MutableState<String>,
    labelID: String = "email",
    enabled: Boolean = true,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    InputFiled(
        modifier = modifier,
        valueState = emailState,
        labelID = labelID,
        enabled = enabled,
        keyboardType = KeyboardType.Email,
        imeAction = imeAction,
        onAction = onAction


    )

}

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    passwordState: MutableState<String>,
    enabled: Boolean,
    passwordVisibility: MutableState<Boolean>,
    onAction: KeyboardActions = KeyboardActions.Default,
    imeAction: ImeAction = ImeAction.Done,
    labelID: String = "Password",

    ) {

    val visualTransformation = if (passwordVisibility.value) VisualTransformation.None
    else PasswordVisualTransformation()

    OutlinedTextField(value = passwordState.value,
        onValueChange = {
            passwordState.value = it
        },
        label = { Text(text = labelID) },
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 18.sp, color = MaterialTheme.colorScheme.onBackground
        ),
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password, imeAction = imeAction
        ),
        visualTransformation = visualTransformation,
        trailingIcon = {
            PasswordVisibility(passwordVisibility = passwordVisibility)
        }
    )

}

@Composable
fun PasswordVisibility(passwordVisibility: MutableState<Boolean>) {
    val visible = passwordVisibility.value
    IconButton(onClick = {
        passwordVisibility.value = !visible
    }) {

        Icons.Default.Close
    }
}
