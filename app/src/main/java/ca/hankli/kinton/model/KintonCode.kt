package ca.hankli.kinton.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class KintonCode(
    @Json(name = "action") val action: Int, // 1: withdraw, 2: deposit
    @Json(name = "points") val points: Int,
    @Json(name = "description") val description: String
)