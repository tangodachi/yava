package com.tangodachi.yava

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tangodachi.design.Button
import com.tangodachi.design.Text
import com.tangodachi.design.TextField
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import com.tangodachi.yava.usecase.RequestSignInCode
import com.tangodachi.yava.usecase.ValidateSignInCode
import kotlinx.coroutines.launch
import yava.composeapp.generated.resources.Res
import yava.composeapp.generated.resources.sign_in_action_request_code
import yava.composeapp.generated.resources.sign_in_action_sign_in
import yava.composeapp.generated.resources.sign_in_label_code
import yava.composeapp.generated.resources.sign_in_label_email

@Composable
fun SignInPage(
    requestSignInCode: RequestSignInCode = koinInject(),
    validateSignInCode: ValidateSignInCode = koinInject()
) {
    var email by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    var signIncodeRequested by remember { mutableStateOf(false) }

    SignInPage(
        email = email,
        code = code,
        onEmailChange = { email = it },
        onCodeChange = { code = it },
        onRequest = {
            scope.launch {
                requestSignInCode(email)
                signIncodeRequested = true
            }
        },
        onSignIn = {
            scope.launch {
                validateSignInCode(email, code)
            }
        },
        signIncodeRequested = signIncodeRequested,
    )
}

@Composable
fun SignInPage(
    email: String,
    code: String,
    onEmailChange: (String) -> Unit,
    onCodeChange: (String) -> Unit,
    onRequest: () -> Unit,
    onSignIn: () -> Unit,
    signIncodeRequested: Boolean,
) {
    Column(
        Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 32.dp)
    ) {
        TextField(
            label = { Text(stringResource(Res.string.sign_in_label_email)) },
            value = email,
            onValueChange = onEmailChange,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(visible = signIncodeRequested) {
            TextField(
                value = code,
                onValueChange = onCodeChange,
                label = { Text(stringResource(Res.string.sign_in_label_code)) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onRequest,
            modifier = Modifier
                .align(Alignment.End)
        ) {
            Text(stringResource(Res.string.sign_in_action_request_code))
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(
            visible = signIncodeRequested,
            modifier = Modifier.align(Alignment.End)
        ) {
            Button(onClick = onSignIn) {
                Text(stringResource(Res.string.sign_in_action_sign_in))
            }
        }
    }
}