 package com.example.mdcjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.LocalContentAlpha


 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                ContentMain()
            }
        }
    }



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContentMain() {
 Scaffold( modifier = Modifier.fillMaxSize(),

     containerColor = Color.DarkGray,

            bottomBar = {
                BottomAppBar(
                    containerColor = Color.Red,
                    contentColor = Color.Yellow
                ) {

                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.Menu,  "Menu")
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f, true))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.MoreVert,  "Options")
                    }
                     FloatingActionButton(
                        shape= CircleShape,
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(Icons.Filled.Create, null)
                    }

                }

            },
     floatingActionButtonPosition = FabPosition.Center
 )
 { padding ->
     Content(Modifier.padding(padding))
 }
}





































 