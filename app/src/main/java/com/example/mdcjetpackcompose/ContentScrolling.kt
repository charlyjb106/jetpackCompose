package com.example.mdcjetpackcompose

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.wear.compose.material.Checkbox
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.Switch
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.mdcjetpackcompose.ui.theme.MDCJetpackcomposeTheme

/**
 * Class that show the content of the view.
 * It means the textviews, etc..
 */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContentPreview(){
    
    MDCJetpackcomposeTheme {
        Content()
    }
    
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(id = R.dimen.common_padding_default),
                        end = dimensionResource(id = R.dimen.common_padding_default),
                        top = dimensionResource(id = R.dimen.common_padding_default)
                    )
            ) {
                val (imgCard, btnBuy, btnSkip, tvTitle, tvContent) = createRefs()

                val image = ContextCompat.getDrawable(LocalContext.current, R.mipmap.ic_launcher)
                Image(bitmap = image!!.toBitmap().asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .constrainAs(imgCard) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        })

                ExtendedFloatingActionButton(
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.common_padding_min))
                        .constrainAs(btnBuy) {
                            end.linkTo(parent.end)
                            top.linkTo(imgCard.bottom)
                        },
                    onClick = { /* do something */ },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_shop),
                            contentDescription = null
                        )
                    },
                    text = { Text(text = stringResource(id = R.string.card_btn_buy)) },
                )

                TextButton(onClick = { },
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.common_padding_min))
                        .constrainAs(btnSkip) {
                            end.linkTo(btnBuy.start)
                            top.linkTo(btnBuy.top)
                            bottom.linkTo(btnBuy.bottom)
                            height = Dimension.fillToConstraints
                        }) {
                    Text(text = stringResource(id = R.string.card_btn_skip))
                }

                Text(text = stringResource(id = R.string.card_title),
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(start = dimensionResource(id = R.dimen.common_padding_default))
                        .constrainAs(tvTitle) {
                            start.linkTo(imgCard.end)
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                            width = Dimension.fillToConstraints
                        })

                Text(text = stringResource(id = R.string.large_text),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Start,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(id = R.dimen.common_padding_default),
                            top = dimensionResource(id = R.dimen.common_padding_middle)
                        )
                        .constrainAs(tvContent) {
                            start.linkTo(tvTitle.start)
                            end.linkTo(tvTitle.end)
                            top.linkTo(tvTitle.bottom)
                            bottom.linkTo(imgCard.bottom)
                            width = Dimension.fillToConstraints
                        })
            }
        }

        var colorMain by remember { mutableStateOf(Color.LightGray) }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorMain
            )

        ) {
            Column {

/*  Fill images
              Image(
                    painter = painterResource(id = R.drawable.ic_shop)
                    , contentDescription = null,
                    modifier= Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.card_img_cover_height))
                        .background(
                            colorResource(id = R.color.teal_200),
                        )
                )*/

                //var that save the user's input
                var urlValue by remember { mutableStateOf("") }
                //IMAGE USING GLIDE
                GlideImage(
                    model = urlValue,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.card_img_cover_height))
                        .background(
                            colorResource(id = R.color.teal_200),
                        ),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(id = R.string.card_title),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.common_padding_default)),
                    style = MaterialTheme.typography.headlineMedium
                )


                OutlinedTextField(
                    value = urlValue,
                    onValueChange = { urlValue = it }, //assign the user input to the var
                    label = { Text(text = stringResource(id = R.string.card_input_url)) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = dimensionResource(id = R.dimen.common_padding_default),
                            start = dimensionResource(id = R.dimen.common_padding_default),
                            end = dimensionResource(id = R.dimen.common_padding_default)
                        ),
                    trailingIcon = {
                        //if the textfield has data, show the icon, else is hide
                        if (urlValue.isNotEmpty()) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = "Clean",
                                modifier = Modifier
                                    .clickable { urlValue = "" } //onclick clean the textfield
                            )
                        }
                    }
                )

                Text(
                    text = stringResource(id = R.string.card_required),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                        .copy(alpha = ContentAlpha.medium),
                    modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.common_padding_default),
                        end = dimensionResource(id = R.dimen.common_padding_micro)
                    )
                )

                var isCheckboxChecked by remember { mutableStateOf(true) }
                //var for the password user
                var passwordValue by remember { mutableStateOf("") }
                var isPasswordVisible by remember { mutableStateOf(false) }

                OutlinedTextField(
                    value = passwordValue,
                    onValueChange = { passwordValue = it }, //assign the user input to the var
                    label = { Text(text = stringResource(id = R.string.card_password)) },
                    singleLine = true,
                    enabled = isCheckboxChecked,
                    //check if the user make password visible and show or encrypt it.
                    visualTransformation = if (isPasswordVisible)
                        VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = dimensionResource(id = R.dimen.common_padding_default),
                            start = dimensionResource(id = R.dimen.common_padding_default),
                            end = dimensionResource(id = R.dimen.common_padding_default)
                        ),

                    trailingIcon = {

                        if (urlValue.isNotEmpty()) {
                            Icon(
                                painter = if (isPasswordVisible)
                                    painterResource(id = R.drawable.ic_visibility_off)
                                else painterResource(id = R.drawable.ic_visibility),
                                contentDescription = null,
                                modifier = Modifier
                                    .clickable { isPasswordVisible = !isPasswordVisible }
                            )
                        }
                    }
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        /*                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.Red
                        ),*/
                        checked = isCheckboxChecked,
                        onCheckedChange = { isCheckboxChecked = it }
                    )
                    Text(text = stringResource(id = R.string.enable_password))

                    Spacer(modifier = Modifier.weight(1f))

                    Text(text = stringResource(id = R.string.card_hide_fab))

                    var isSwitchChecked by remember { mutableStateOf(true) }
                    Switch(
                        checked = isSwitchChecked,
                        onCheckedChange = { isSwitchChecked = it },
                        modifier = Modifier.padding(
                            end = dimensionResource(id = R.dimen.common_padding_default)
                        )
                    )
                }

                val context = LocalContext.current
                var sliderValue by remember { mutableStateOf(6f) }
                Slider(
                    value = sliderValue,
                    onValueChange = {
                        sliderValue = it
                        urlValue = "Vol: ${it.toInt()}"
                    },
                    onValueChangeFinished = {
                        Toast.makeText(context, "vol: $sliderValue", Toast.LENGTH_SHORT).show()
                    },
                    valueRange = 0f..10f,
                    steps = 10 //indicates the number of divisions, not the value change
                )

                val emailValue by remember { mutableStateOf("email@email.com") }
                var cpVisible by remember { mutableStateOf(true) }

                if (cpVisible) {

                    Chip(  // FIXME: Make it looks better 
                        onClick = {
                            Toast.makeText(context, emailValue, Toast.LENGTH_SHORT).show()
                        },
                        colors = ChipDefaults.imageBackgroundChipColors(
                            backgroundImagePainter = painterResource(id = R.drawable.ic_visibility)
                        ),
                        border = ChipDefaults.chipBorder(),
                        modifier = Modifier.padding(
                            start = dimensionResource(id = R.dimen.common_padding_default)
                        )
                    ) {

                        Text(text = emailValue)
                        Icon(imageVector = Icons.Filled.Close,
                            contentDescription = null,
                            modifier = Modifier
                                .size(16.dp)
                                .clickable { cpVisible = false }
                        )
                    }
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = dimensionResource(id = R.dimen.common_padding_middle))
                )

                val colors = listOf("Red", "Blue", "Green")
                SegmentedControl(
                    items = colors,
                    defaultSelectedItemIndex = -1,
                    cornerRadius = 48,
                    color = R.color.purple_500,
                    onItemSelection = {

                        colorMain = when (it) {
                            0 -> Color.Red
                            1 -> Color.Blue
                            else -> Color.Green
                        }

                    }
                )


            }
        }
    }
}























