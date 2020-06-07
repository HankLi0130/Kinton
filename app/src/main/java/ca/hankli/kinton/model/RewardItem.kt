package ca.hankli.kinton.model

import ca.hankli.kinton.util.json.qualifier.IconResource
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RewardItem(
    @Json(name = "id") val id: Int,
    @Json(name = "pic") @IconResource val iconRes: Int,
    @Json(name = "title") val title: String,
    @Json(name = "requested_points") val requestedPoints: Int,
    @Json(name = "minimum_bowls") val minimumBowls: Int
)