package ca.hankli.kinton.model

import ca.hankli.kinton.util.json.qualifier.IconResource
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MenuCategory(
    @Json(name = "id") val id: Int,
    @Json(name = "pic") @IconResource val iconRes: Int,
    @Json(name = "name") val name: String,
    @Json(name = "type") val type: Int
)