package com.ghostapps.placapp.viewModel.gameScore

import com.ghostapps.placapp.viewModel.BaseViewModel

class GameScoreViewModel(
    private val contract: GameScoreContract
): BaseViewModel() {

    var homeTeamName = ""
    var awayTeamName = ""

    var homeTeamScore = 0
    var awayTeamScore = 0

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
        contract.onExitPressed()
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