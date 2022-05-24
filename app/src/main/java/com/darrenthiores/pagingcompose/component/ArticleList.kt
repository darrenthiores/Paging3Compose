package com.darrenthiores.pagingcompose.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.darrenthiores.pagingcompose.data.Article

@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(articles) {
            ArticleItem(article = it!!)
        }
    }
}