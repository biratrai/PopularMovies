package com.gooner10.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "moviedata")
data class MovieItem(

        @PrimaryKey(autoGenerate = false)
        @field:SerializedName("id")
        var id: Int,

        @ColumnInfo
        @field:SerializedName("overview")
        var overview: String,

        @ColumnInfo
        @field:SerializedName("original_language")
        var originalLanguage: String,

        @ColumnInfo
        @field:SerializedName("original_title")
        var originalTitle: String,

        @ColumnInfo
        @field:SerializedName("video")
        var video: Boolean,

        @ColumnInfo
        @field:SerializedName("title")
        var title: String,

        @ColumnInfo
        @field:SerializedName("poster_path")
        var posterPath: String,

        @ColumnInfo
        @field:SerializedName("backdrop_path")
        var backdropPath: String,

        @ColumnInfo
        @field:SerializedName("release_date")
        var releaseDate: String,

        @ColumnInfo
        @field:SerializedName("vote_average")
        var voteAverage: Double,

        @ColumnInfo
        @field:SerializedName("popularity")
        var popularity: Double,

        @ColumnInfo
        @field:SerializedName("adult")
        var adult: Boolean,

        @ColumnInfo
        @field:SerializedName("vote_count")
        var voteCount: Int
) : Parcelable