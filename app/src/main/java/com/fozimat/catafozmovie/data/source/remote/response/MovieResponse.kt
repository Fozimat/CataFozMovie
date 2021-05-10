package com.fozimat.catafozmovie.data.source.remote.response

data class MovieResponse(
    var title: String,
    var year: Int,
    var genre: String,
    var description: String,
    var duration: String,
    var image: String
)