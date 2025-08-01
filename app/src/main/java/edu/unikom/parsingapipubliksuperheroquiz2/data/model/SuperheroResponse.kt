package edu.unikom.parsingapipubliksuperheroquiz2.data.model

import com.google.gson.annotations.SerializedName

data class SuperheroResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("biography") val biography: Biography,
    @SerializedName("images") val images: Images
)

data class Biography(
    @SerializedName("fullName") val fullName: String
)

data class Images(
    @SerializedName("lg") val imageUrl: String
)
