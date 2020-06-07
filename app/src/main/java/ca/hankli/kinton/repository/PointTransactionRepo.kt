package ca.hankli.kinton.repository

import ca.hankli.kinton.data.entity.PointTransaction
import ca.hankli.kinton.data.source.pointTransactions
import ca.hankli.kinton.util.ZERO
import java.time.LocalDate

class PointTransactionRepo {

    fun withdraw(description: String, points: Int) {
        val pointTransaction = PointTransaction(
            LocalDate.now(),
            description,
            "Church",
            withdrawal = points,
            balance = (getCurrentBalance() - points)
        )
        pointTransactions.add(pointTransaction)
    }

    fun deposit(description: String, points: Int) {
        val pointTransaction = PointTransaction(
            LocalDate.now(),
            description,
            "Church",
            deposit = points,
            balance = (getCurrentBalance() + points)
        )
        pointTransactions.add(pointTransaction)
    }

    fun getTotalPointsOfWithdrawals(): Int {
        return if (pointTransactions.isEmpty()) ZERO else pointTransactions.sumBy { it.withdrawal }
    }

    fun getTotalPointsOfDeposits(): Int {
        return if (pointTransactions.isEmpty()) ZERO else pointTransactions.sumBy { it.deposit }
    }

    fun getCurrentBalance(): Int {
        return if (pointTransactions.isEmpty()) ZERO else pointTransactions.last().balance
    }
}