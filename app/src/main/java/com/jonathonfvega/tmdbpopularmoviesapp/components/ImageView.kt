package com.jonathonfvega.tmdbpopularmoviesapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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