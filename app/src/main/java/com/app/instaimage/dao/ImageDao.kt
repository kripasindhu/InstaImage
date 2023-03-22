package com.app.instaimage.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.instaimage.entity.ImagesEntity

/**
 * Used to query cached Images
 */
@Dao
interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(images: List<ImagesEntity>)

    @Query("SELECT * FROM pix_image_table WHERE searchTerm LIKE :query")
    fun queryImages(query: String): PagingSource<Int, ImagesEntity>

    @Query("DELETE FROM pix_image_table")
    suspend fun clearAll()

    @Query("SELECT * FROM pix_image_table")
    suspend fun getAll(): List<ImagesEntity>

}