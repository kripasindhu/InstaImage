package com.app.instaimage.mappers

import com.app.instaimage.entity.ImagesEntity
import com.app.instaimage.modal.ImageModal
import com.app.instaimage.modal.Image


fun ImagesEntity.toDomainImage(): Image {
    return Image(
        comments = comments,
        downloads = downloads,
        id = id,
        largeImageURL = largeImageURL,
        likes = likes,
        tags = tags,
        user = user,
        user_id = user_id,
        views = views,
        searchTerm = searchTerm
    )
}

fun ImageModal.toImageEntity(searchSting:String): ImagesEntity {
    return ImagesEntity(
        comments = comments,
        downloads = downloads,
        id = id,
        largeImageURL = largeImageURL,
        likes = likes,
        tags = tags,
        user = user,
        user_id = user_id,
        views = views,
        searchTerm = searchSting
    )
}



