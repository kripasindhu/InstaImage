package com.app.instaimage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.app.instaimage.common.DEFAULT_SEARCH
import com.app.instaimage.usecases.SearchUseCase
import com.app.instaimage.mappers.toImagePresentation
import com.app.instaimage.modal.ImagePresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
) : ViewModel() {


    var selectedImage: ImagePresentation? = null
    private val defaultSearch = DEFAULT_SEARCH
    var currentSearch = defaultSearch

    fun searchImages(searchString: String): Flow<PagingData<ImagePresentation>> {
        currentSearch = searchString
        return searchUseCase(searchString).map { paginatedData ->
            paginatedData.map { image ->
                image.toImagePresentation()
            }
            paginatedData.map { data ->
                data.toImagePresentation()
            }

        }.cachedIn(viewModelScope)
    }

}