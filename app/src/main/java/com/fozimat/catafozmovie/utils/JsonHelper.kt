package com.fozimat.catafozmovie.utils

import android.content.Context
import com.fozimat.catafozmovie.data.source.remote.response.MovieResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val respondObject = JSONObject(parsingFileToString("MovieResponse.json").toString())
            val listArray = respondObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)
                val title = movie.getString("title")
                val year = movie.getInt("year")
                val genre = movie.getString("genre")
                val description = movie.getString("description")
                val duration = movie.getString("duration")
                val image = movie.getString("image")

                val movieResponse = MovieResponse(title, year, genre, description, duration, image)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShow(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val respondObject = JSONObject(parsingFileToString("TvShowResponse.json").toString())
            val listArray = respondObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)
                val title = movie.getString("title")
                val year = movie.getInt("year")
                val genre = movie.getString("genre")
                val description = movie.getString("description")
                val duration = movie.getString("duration")
                val image = movie.getString("image")

                val showResponse = MovieResponse(title, year, genre, description, duration, image)
                list.add(showResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}