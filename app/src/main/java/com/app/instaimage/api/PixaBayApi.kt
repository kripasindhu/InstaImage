package com.app.instaimage.api

import com.app.instaimage.modal.ImageResponseModal
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaBayApi {

    @GET("api/")
    suspend fun searchImages(
        @Query("q") searchString: String? = null,
        @Query("per_page") per_page: Int? = null,
        @Query("page") page: Int? = null,
    ): ImageResponseModal
}