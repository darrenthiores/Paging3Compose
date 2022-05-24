package com.darrenthiores.pagingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.darrenthiores.pagingcompose.component.ArticleList
import com.darrenthiores.pagingcompose.data.Article
import com.darrenthiores.pagingcompose.ui.theme.PagingComposeTheme
import com.darrenthiores.pagingcompose.vm.ArticleViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<ArticleViewModel>(
            factoryProducer = { Injection.provideViewModelFactory(owner = this) }
        )

        setContent {
            PagingComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val articles: LazyPagingItems<Article> = viewModel.items.collectAsLazyPagingItems()
                    ArticleList(articles = articles)
                }
            }
        }
    }
}