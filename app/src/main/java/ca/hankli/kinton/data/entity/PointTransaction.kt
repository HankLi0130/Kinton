package ca.hankli.kinton.data.entity

import java.time.LocalDate

data class PointTransaction(
    val date: LocalDate,
    val description: String,
    val branch: String,
    val withdrawal: Int = 0,
    val deposit: Int = 0,
    val balance: Int
) {
    override fun toString(): String {
        return "PointTransaction(date=$date, description='$description', withdrawal=$withdrawal, deposit=$deposit, balance=$balance)"
    }
}