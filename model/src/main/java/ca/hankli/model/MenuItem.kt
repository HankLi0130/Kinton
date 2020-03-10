package ca.hankli.model

import java.math.BigDecimal

data class MenuItem(
    val id: Int,
    val iconRes: Int,
    val title: String,
    val subtitle: String,
    val price: BigDecimal
)