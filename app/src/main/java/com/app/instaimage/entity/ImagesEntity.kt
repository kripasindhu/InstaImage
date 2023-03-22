package com.app.instaimage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pix_image_table")
data class ImagesEntity(
    @PrimaryKey(autoGenerate = true) val imageId: Int = 0,
    val comments: Int,
    val downloads: Int,
    val id: Int,
    val largeImageURL: String,
    val likes: Int,
    val tags: String,
    val user: String,
    val user_id: Int,
    val views: Int,
    var searchTerm: String?
)
