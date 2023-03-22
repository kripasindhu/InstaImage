package com.app.instaimage.usecases

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.app.instaimage.modal.Image
import com.app.instaimage.repository.SearchImagesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val searchImagesRepository: SearchImagesRepository) {

    @OptIn(ExperimentalPagingApi::class)
   operator fun invoke(payload: String): Flow<PagingData<Image>> {
        return searchImagesRepository.searchImages(payload)
    }
}