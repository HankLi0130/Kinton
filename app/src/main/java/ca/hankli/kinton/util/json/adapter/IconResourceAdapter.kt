package ca.hankli.kinton.util.json.adapter

import android.content.Context
import ca.hankli.kinton.util.EMPTY
import ca.hankli.kinton.util.json.qualifier.IconResource
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class IconResourceAdapter(private val context: Context) {

    companion object {
        private const val DRAWABLE = "drawable"
    }

    @ToJson
    fun toJson(@IconResource iconRes: Int): String {
        return EMPTY
    }

    @FromJson
    @IconResource
    fun fromJson(pic: String): Int {
        return context.resources.getIdentifier(pic, DRAWABLE, context.packageName)
    }
}