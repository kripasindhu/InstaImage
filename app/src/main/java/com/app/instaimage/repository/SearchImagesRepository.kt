package com.app.instaimage.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.app.instaimage.modal.Image
import kotlinx.coroutines.flow.Flow

interface SearchImagesRepository {
    @ExperimentalPagingApi
    fun searchImages(searchString: String): Flow<PagingData<Image>>

}