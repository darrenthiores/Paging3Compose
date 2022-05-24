package com.darrenthiores.pagingcompose.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.darrenthiores.pagingcompose.data.Article
import com.darrenthiores.pagingcompose.data.ArticleRepository
import kotlinx.coroutines.flow.Flow

private const val ITEMS_PER_PAGE = 50

class ArticleViewModel(
    repository: ArticleRepository,
) : ViewModel() {
    private val _items: Flow<PagingData<Article>> = Pager(
        config = PagingConfig(pageSize = ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { repository.articlePagingSource() }
    )
        .flow
        .cachedIn(viewModelScope)

    val items: Flow<PagingData<Article>>
        get() = _items
}
