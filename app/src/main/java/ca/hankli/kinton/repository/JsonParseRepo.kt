package ca.hankli.kinton.repository

import ca.hankli.kinton.model.KintonCode
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi

class JsonParseRepo(val moshi: Moshi) {

    fun parseKintonCodeJson(json: String): KintonCode? {
        return try {
            moshi.adapter(KintonCode::class.java).fromJson(json)
        } catch (e: JsonDataException) {
            null
        }
    }
}