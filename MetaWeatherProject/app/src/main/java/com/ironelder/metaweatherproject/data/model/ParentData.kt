package com.ironelder.metaweatherproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ParentData(

    @SerializedName("latt_long")
    @Expose
    val latt_long: String,

    @SerializedName("location_type")
    @Expose
    val location_type: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("woeid")
    @Expose
    val woeid: Int

)