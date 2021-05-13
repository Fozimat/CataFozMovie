package com.fozimat.catafozmovie.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_show_entities")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "year")
    var year: Int,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "favorited")
    var favorited: Boolean = false,

    @ColumnInfo(name = "isTvShow")
    var isTvShow: Boolean = true
)