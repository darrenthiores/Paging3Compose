package com.darrenthiores.pagingcompose.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.time.LocalDateTime
import kotlin.math.max

private const val STARTING_KEY = 0
private const val ITEMS_PER_PAGE = 50
private val firstArticleCreatedTime = LocalDateTime.now()

class ArticlePagingSource: PagingSource<Int, Article>() {

    private fun ensureValidKey(key: Int) = max(STARTING_KEY, key)

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        // Start paging with the STARTING_KEY if this is the first load
        val start = params.key ?: STARTING_KEY

        val range = start.until(start + params.loadSize)

        return LoadResult.Page(
            data = range.map { number ->
                Article(
                    id = number,
                    title = "Article $number",
                    description = "Description of $number",
                    date = firstArticleCreatedTime.minusDays(number.toLong())
                )
            },
            prevKey = when (start) {
                STARTING_KEY -> null
                else -> ensureValidKey(key = range.first - params.loadSize)
            },
            nextKey = range.last + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val article = state.closestItemToPosition(anchorPosition) ?: return null
        return ensureValidKey(key = article.id - ITEMS_PER_PAGE)
    }

}