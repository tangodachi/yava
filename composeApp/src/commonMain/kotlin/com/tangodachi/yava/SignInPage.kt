package com.tangodachi.yava

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tangodachi.design.Text
import com.tangodachi.design.TextField
import org.jetbrains.compose.resources.stringResource
import yava.composeapp.generated.resources.Res
import yava.composeapp.generated.resources.sign_in_label_email

@Composable
fun SignInPage() {
    TextField(
        label = { Text(stringResource(Res.string.sign_in_label_email)) },
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}