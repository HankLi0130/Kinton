package ca.hankli.kinton.repository

import ca.hankli.kinton.model.KintonCode
import ca.hankli.kinton.model.MenuCategory
import ca.hankli.kinton.model.MenuItem
import ca.hankli.kinton.model.RewardItem
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class JsonParseRepo(val moshi: Moshi) {

    @Throws(JsonDataException::class)
    fun parseKintonMenuCategories(json: String): List<MenuCategory>? {
        val type = Types.newParameterizedType(List::class.java, MenuCategory::class.java)
        val adapter: JsonAdapter<List<MenuCategory>> = moshi.adapter(type)
        return adapter.fromJson(json)
    }

    @Throws(JsonDataException::class)
    fun parseKintonMenuItems(json: String): List<MenuItem>? {
        val type = Types.newParameterizedType(List::class.java, MenuItem::class.java)
        val adapter: JsonAdapter<List<MenuItem>> = moshi.adapter(type)
        return adapter.fromJson(json)
    }

    @Throws(JsonDataException::class)
    fun parseKintonRewardItems(json: String): List<RewardItem>? {
        val type = Types.newParameterizedType(List::class.java, RewardItem::class.java)
        val adapter: JsonAdapter<List<RewardItem>> = moshi.adapter(type)
        return adapter.fromJson(json)
    }

    @Throws(JsonDataException::class)
    fun parseKintonCode(json: String): KintonCode? {
        return moshi.adapter(KintonCode::class.java).fromJson(json)
    }
}