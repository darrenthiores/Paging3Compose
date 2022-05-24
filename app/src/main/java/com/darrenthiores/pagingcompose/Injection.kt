package com.darrenthiores.pagingcompose

import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.darrenthiores.pagingcompose.data.ArticleRepository
import com.darrenthiores.pagingcompose.vm.ViewModelFactory

object Injection {

    private fun provideArticleRepository(): ArticleRepository = ArticleRepository()

    fun provideViewModelFactory(owner: SavedStateRegistryOwner): ViewModelProvider.Factory {
        return ViewModelFactory(owner, provideArticleRepository())
    }

}
