package com.app.instaimage.repository

import androidx.paging.*
import com.app.instaimage.api.PixaBayApi
import com.app.instaimage.db.PixaBayRoomDb
import com.app.instaimage.mappers.toDomainImage
import com.app.instaimage.mediator.PixaBayRemoteMediator
import com.app.instaimage.modal.Image
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class SearchImagesRepositoryImpl @Inject constructor(
    private val pixaBayApi: PixaBayApi,
    private val pixaBayRoomDb: PixaBayRoomDb,
) : SearchImagesRepository {
    @ExperimentalPagingApi
    override fun searchImages(searchString: String): Flow<PagingData<Image>> {
        val pagingSourceFactory = { pixaBayRoomDb.imageDao().queryImages(searchString) }

        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                maxSize = NETWORK_PAGE_SIZE + (NETWORK_PAGE_SIZE * 2),
                enablePlaceholders = false
            ),
            remoteMediator = PixaBayRemoteMediator(
                searchString,
                pixaBayApi,
                pixaBayRoomDb
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow.map { pagingData ->
            pagingData.map { imageEntity ->
                imageEntity.toDomainImage()
            }
        }
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }

}