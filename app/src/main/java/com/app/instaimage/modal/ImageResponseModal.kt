package com.app.instaimage.modal

import com.google.gson.annotations.SerializedName

class ImageResponseModal(
    @SerializedName("hits")
    val images: List<ImageModal>,
    val total: Int,
    val totalHits: Int
)