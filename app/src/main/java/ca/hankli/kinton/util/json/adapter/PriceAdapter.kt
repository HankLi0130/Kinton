package ca.hankli.kinton.util.json.adapter

import ca.hankli.kinton.util.ZERO_DOUBLE
import ca.hankli.kinton.util.json.qualifier.Price
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.math.BigDecimal

class PriceAdapter {

    @ToJson
    fun toJson(@Price price: BigDecimal): Double {
        return ZERO_DOUBLE
    }

    @FromJson
    @Price
    fun fromJson(price: String): BigDecimal {
        return BigDecimal(price)
    }
}