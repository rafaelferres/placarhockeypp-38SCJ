package com.ghostapps.placapp.viewModel.gameScore

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.ghostapps.placapp.viewModel.BaseViewModel
import java.util.*

class GameScoreViewModel(
    private val contract: GameScoreContract,
    private val insertRegister: InsertRegister
): BaseViewModel() {

    var homeTeamName = ""
    var awayTeamName = ""

    private var homeTeamScore = 0
    private var awayTeamScore = 0

    var homeTeamFaul = 0
    var awayTeamFaul = 0

    var formattedHomeTeamScore = "00"
    var formattedAwayTeamScore = "00"

    var formattedHomeTeamFaul = "00"
    var formattedAwayTeamFaul = "00"

    fun onCreate(homeTeamName: String, awayTeamName: String) {
        this.homeTeamName = homeTeamName
        this.awayTeamName = awayTeamName
    }

    fun onHomeTeamIncrease() {
        homeTeamScore++
        updateScore()
    }

    fun onHomeTeamDecrease() {
        if (homeTeamScore > 0) homeTeamScore--
        updateScore()
    }

    fun onAwayTeamIncrease() {
        awayTeamScore++
        updateScore()
    }

    fun onAwayTeamDecrease() {
        if (awayTeamScore > 0) awayTeamScore--
        updateScore()
    }

    fun onFaulAwayTeamIncrease() {
        awayTeamFaul++
        updateFaul()
    }

    fun onFaulAwayTeamDecrease() {
        if (awayTeamFaul > 0) awayTeamFaul--
        updateFaul()
    }

    fun onFaulHomeTeamIncrease() {
        homeTeamFaul++
        updateFaul()
    }

    fun onFaulHomeTeamDecrease() {
        if (homeTeamFaul > 0) homeTeamFaul--
        updateFaul()
    }

    fun onExitPressed() {
        Thread {
            val success = insertRegister.execute(RecordModel(
                homeTeamName = homeTeamName,
                homeTeamScore = homeTeamScore,
                awayTeamName = awayTeamName,
                awayTeamScore = awayTeamScore,
                awayTeamFauls = awayTeamFaul,
                homeTeamFauls = homeTeamFaul,
                date = Date().time
            )) as Boolean;

            contract.onExitPressed()

        }.start()
    }

    private fun updateScore() {
        formattedHomeTeamScore = String.format("%02d", homeTeamScore)
        formattedAwayTeamScore = String.format("%02d", awayTeamScore)

        notifyChange()
    }

    private fun updateFaul() {
        formattedHomeTeamFaul = String.format("%02d", homeTeamFaul)
        formattedAwayTeamFaul = String.format("%02d", awayTeamFaul)

        notifyChange()
    }
}