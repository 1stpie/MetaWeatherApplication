package com.ironelder.metaweatherproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SourceData(

    @SerializedName("crawl_rate")
    @Expose
    val crawl_rate: Int,

    @SerializedName("slug")
    @Expose
    val slug: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("url")
    @Expose
    val url: String
)