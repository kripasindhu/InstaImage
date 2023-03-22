package com.app.instaimage.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.instaimage.dao.ImageDao
import com.app.instaimage.dao.RemoteKeyDao
import com.app.instaimage.entity.ImagesEntity
import com.app.instaimage.entity.RemoteKey

/**
 * Used to store images.
 */

@Database(
    entities = [ImagesEntity::class, RemoteKey::class],
    version = 1, exportSchema = false
)
abstract class PixaBayRoomDb : RoomDatabase() {
    abstract fun imageDao(): ImageDao
    abstract fun remoteKeyDao(): RemoteKeyDao

}