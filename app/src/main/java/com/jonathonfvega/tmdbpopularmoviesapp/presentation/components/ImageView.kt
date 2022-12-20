package com.jonathonfvega.tmdbpopularmoviesapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageView(
    imageUrl: String
) {
    Box(modifier = Modifier.height(300.dp)) {
        GlideImage(
            modifier = Modifier.fillMaxWidth(),
            model = imageUrl,
            contentDescription = "J",
            contentScale = ContentScale.FillWidth
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BackDropHeaderImageView(
    imageUrl: String
) {
    Box() {
        GlideImage(
            modifier = Modifier.fillMaxWidth(),
            model = imageUrl,
            contentDescription = "J",
            contentScale = ContentScale.FillWidth,
            alpha = 0.4f
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PosterImageView(
    imageUrl: String
) {
    Box(modifier = Modifier.clip(RoundedCornerShape(10.dp))) {
        GlideImage(
            modifier = Modifier.width(150.dp),
            model = imageUrl,
            contentDescription = "J",
            contentScale = ContentScale.FillWidth,
            )
    }
}
