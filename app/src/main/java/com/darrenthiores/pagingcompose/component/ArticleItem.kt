package com.darrenthiores.pagingcompose.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.darrenthiores.pagingcompose.data.Article
import com.darrenthiores.pagingcompose.data.createdText

@Composable
fun ArticleItem(
    modifier: Modifier = Modifier,
    article: Article
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                1.5.dp,
                MaterialTheme.colors.primary
            )
    ){
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = article.title)
            Text(text = article.description)
            Text(text = article.createdText)
        }
    }
}