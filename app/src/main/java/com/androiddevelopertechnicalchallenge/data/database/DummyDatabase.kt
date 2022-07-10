package com.androiddevelopertechnicalchallenge.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androiddevelopertechnicalchallenge.data.converters.ProductTypeConverter
import com.androiddevelopertechnicalchallenge.data.daos.ProductDao
import com.androiddevelopertechnicalchallenge.data.entities.ProductEntity

@Database(
    entities = [ProductEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ProductTypeConverter::class)
abstract class DummyDatabase : RoomDatabase(){

    abstract fun productDao(): ProductDao
}