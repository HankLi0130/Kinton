package ca.hankli.kinton.model

import ca.hankli.kinton.util.json.qualifier.IconResource
import ca.hankli.kinton.util.json.qualifier.Price
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.math.BigDecimal

@JsonClass(generateAdapter = true)
data class MenuItem(
    @Json(name = "id") val id: Int,
    @Json(name = "type") val type: Int,
    @Json(name = "pic") @IconResource val iconRes: Int,
    @Json(name = "title") val title: String,
    @Json(name = "subtitle") val subtitle: String,
    @Json(name = "price") @Price val price: BigDecimal
)