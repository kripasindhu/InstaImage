package com.app.instaimage.modal

data class ImageModal(
    val comments: Int,
    val downloads: Int,
    val id: Int,
    val largeImageURL: String,
    val likes: Int,
    val tags: String,
    val user: String,
    val user_id: Int,
    val views: Int,
    var searchTerm: String? = null
)