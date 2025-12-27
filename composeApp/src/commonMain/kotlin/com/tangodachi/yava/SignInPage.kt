package com.tangodachi.yava

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tangodachi.design.Button
import com.tangodachi.design.Text
import com.tangodachi.design.TextField
import org.jetbrains.compose.resources.stringResource
import yava.composeapp.generated.resources.Res
import yava.composeapp.generated.resources.sign_in_action_request_code
import yava.composeapp.generated.resources.sign_in_label_email

@Composable
fun SignInPage() {
    SignInPage(onRequest = {})
}

@Composable
fun SignInPage(
    onRequest: () -> Unit
) {
    Column(
        Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 32.dp)
    ) {
        TextField(
            label = { Text(stringResource(Res.string.sign_in_label_email)) },
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onRequest,
            modifier = Modifier
                .align(Alignment.End)
        ) {
            Text(stringResource(Res.string.sign_in_action_request_code))
        }
    }
}