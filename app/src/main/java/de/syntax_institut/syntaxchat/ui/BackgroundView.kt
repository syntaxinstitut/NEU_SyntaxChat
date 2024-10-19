package de.syntax_institut.syntaxchat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import de.syntax_institut.syntaxchat.R

@Composable
fun BackgroundView() {
    Image(
        painter = painterResource(R.drawable.wallpaper_1),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showSystemUi = true)
@Composable
fun BackgroundPreview() {
    BackgroundView()
}