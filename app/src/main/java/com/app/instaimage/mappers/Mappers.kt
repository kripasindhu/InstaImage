package com.app.instaimage.mappers

import com.app.instaimage.modal.Image
import com.app.instaimage.modal.ImagePresentation


fun Image.toImagePresentation(): ImagePresentation {
    return ImagePresentation(
        comments, downloads, id, largeImageURL, likes, tags, user, user_id, views, searchTerm
    )
}

