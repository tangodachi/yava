package com.tangodachi.yava

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tangodachi.design.Scaffold
import com.tangodachi.design.Text
import com.tangodachi.design.TopBar
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import yava.composeapp.generated.resources.Res
import yava.composeapp.generated.resources.top_bar_title_sign_in

@Composable
@Preview
fun App() {
    Scaffold(
        topBar = {
            TopBar(
                title = { Text(stringResource(Res.string.top_bar_title_sign_in)) }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            SignInPage()
        }
    }
}