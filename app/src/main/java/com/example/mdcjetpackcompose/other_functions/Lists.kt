package com.example.mdcjetpackcompose.other_functions

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mdcjetpackcompose.ui.theme.MDCJetpackcomposeTheme


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Main() {

    MDCJetpackcomposeTheme {

        MessageList(messages = listOf("aBC", "ASFAS", "asfds"))

    }
}
@Composable
fun MessageList(messages: List<String>) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        items(messages) {
            message -> MessageInfo(message = message)
        }
    }
}


@Composable
fun MessageInfo (message: String) {

    Text(text = message)
}